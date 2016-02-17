package com.cricket.stats;

import com.cricket.stats.util.*;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by mmadhusoodan on 1/9/15.
 */
public class QaReportProcessor {
    public static Logger log = Logger.getLogger(QaReportProcessor.class);

    private String reportName = "";
    private String reportDir = "";
    private String reportScreenshotPath = "";
    private String TestrailURL = "";
    private String testResult = "";
    private String passed = "";
    private String failed = "";
    private String percentagePass = "";
    private String lyvesuitebuildNo = "";
    private String reportTime = "";
    private boolean failuresFlag = false;
    private String userName = "testrailreporter@lyveminds.com";
    private String password = "2vhSJ5982Ge77d8pwW6H";

    public String getRailsReportName() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(QaProperties.getJSONDir() + File.separator + QaConstants.IND_PLAYER_STATS_FILE_JSON));
            JSONObject jsonObject = (JSONObject) obj;
            reportName = (String) jsonObject.get("reportName");
            log.info("reportName: " + reportName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reportName;
    }

    public String LaunchTestRailsAndScreenGrab() throws Exception {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        reportName = getRailsReportName();

        if (!reportName.isEmpty()) {
            reportDir = reportName.split("_t")[0].trim();
            reportDir = reportDir.replace(":", "_");
            QaScreenshot screenShot = new QaScreenshot(driver);
            String BaseURL = "https://testrail.blackpearlsystems.com/index.php?/projects/overview/12";

            try {
                driver.navigate().to(BaseURL);
                driver.manage().window().maximize();

                driver.findElement(By.name("name")).sendKeys(userName);
                driver.findElement(By.name("password")).sendKeys(password);

                driver.findElement(By.className("positive")).click(); // SignIn button is called positive :)
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("id")));

                assertEquals("P12", driver.findElement(By.className("id")).getText().trim());

                assertEquals("Report Not Present", true, driver.findElement(By.linkText(reportName)).isDisplayed());

                driver.findElement(By.linkText(reportName)).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("breadcrumb")));

                //get the Pass percentage pass and fail
                List<WebElement> wLabels = driver.findElements(By.className("title"));
                passed = wLabels.get(4).getText().trim();
                failed = wLabels.get(7).getText().trim();
                percentagePass = wLabels.get(8).getText().trim();

                if (null != failed && Integer.valueOf(failed.split(" ")[0]) > 0) {
                    failuresFlag = true;
                }

                testResult = passed + "\n" + failed + "\n\n" + "Pass Percentage: " + percentagePass + "\n";
                log.info("testResult: " + testResult);

                String TestReportRun = driver.findElement(By.id("breadcrumb")).getText().trim();
                TestrailURL = driver.getCurrentUrl();
                log.info("TestrailURL: " + TestrailURL);

                if (TestReportRun.isEmpty() || !TestReportRun.contains(reportName)) {
                    log.info("Something went wring with testRails");
                } else {

                    reportScreenshotPath = screenShot.reportCapture(driver, reportDir);
                    log.info("reportScreenshotPath: " + reportScreenshotPath);
                }

            } catch (NoSuchElementException nse) {
                log.info(reportName + " Not Found, Probably report was not uploaded ... Exiting");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                driver.close();
            }
        } else {
            log.info("reportName is Empty check testrails.json");
        }
        return reportScreenshotPath;
    }

    public String LaunchMDMAAndGetBuildNo() throws Exception {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        String BaseURL = "http://mdma.inf.blackpearlsystems.net/";

        try {
            driver.navigate().to(BaseURL);
            driver.manage().window().maximize();

            //Verify that your are on the right page
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
            String title = driver.findElement(By.className("title")).getText().trim();
            if (!"mdma".equalsIgnoreCase(title)) {
                log.info("mdma not responding, wait for 2 secs");
                driver.wait(2000);
            }
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grid-dogfood-lyvesuite")));
            lyvesuitebuildNo = driver.findElement(By.id("grid-dogfood-lyvesuite")).getText().trim();
            if (lyvesuitebuildNo.isEmpty()) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grid-prod-lyvesuite")));
                lyvesuitebuildNo = driver.findElement(By.id("grid-prod-lyvesuite")).getText().trim();
            }

            log.info("lyvesuitebuildNo: " + lyvesuitebuildNo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }
        return lyvesuitebuildNo;
    }

    public String getHumanReadableReportTime(String reportTime) {

        try {
            reportTime = (reportScreenshotPath.split("screenshot")[0]);
            reportTime = reportTime.split("reports")[1];
            reportTime = reportTime.split("[a-zA-Z]+_")[1];
            reportTime = reportTime.replace("_", ":");
            reportTime = reportTime.substring(0, reportTime.length() - 1);
            reportTime = QaCalendar.getSlashDateFromHyphenDate(reportTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reportTime;
    }

    public String getEmailBodyWithFailedTestCases() {

        QaFileReader qaFileReader = new QaFileReader();
        String body = "";
        List<String> testcaseList = qaFileReader.getFailedTestCaseListFromTestrailsJSON();

        Iterator<String> iterator = testcaseList.iterator();
        while (iterator.hasNext()) {
            body = body + iterator.next() + "\n";
        }
        return body;
    }

    public void sendFailedEmail() throws Exception {

        String fromEmail = "lyvesuite-automation@lyveminds.com";
        String fromName = "Lyve Suite Automation";
        String toEmail = "lm-automation-team@lyveminds.com";
        String toName = "LM-LyveSuite-Automation";

        try {
            reportTime = getHumanReadableReportTime(reportTime);
            String subject = "[ " + failed.toUpperCase() + " ] " + reportTime + " LyveSuite Automation FAILED";
            String body = "<html><font face='verdana' size='2'><b>Lyve Suite Automation Run:</b> " + reportTime + "\n\n";
            body += "Failed Test Cases\n\n";
            body += getEmailBodyWithFailedTestCases();
            body += "</html>";

            reportName = getRailsReportName();
            QaEmail qaEmail = new QaEmail();
            if (failuresFlag)
                qaEmail.sendEmail(fromEmail, fromName, toEmail, toName, subject, body);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Test
    public void sendEmailWithAttachment() throws Exception {

        reportScreenshotPath = LaunchTestRailsAndScreenGrab();
        lyvesuitebuildNo = LaunchMDMAAndGetBuildNo();
        if ("".equalsIgnoreCase(reportScreenshotPath)) {
            log.info("Reports Path is empty, possibly not found on testrail ...NO EMAIL would be sent ... exiting ");
        } else {
            String fromEmail = "lyvesuite-automation@lyveminds.com";
            String fromName = "Lyve Suite Automation";
            String toEmail = "lm-lyvesuite-automation@lyveminds.com";
//            String toEmail = "mmadhusoodan@lyveminds.com";
            String toName = "LM-LyveSuite-Automation";
            String subject = "";
            String body = "";

            try {
                reportTime = getHumanReadableReportTime(reportTime);
                subject = "LyveSuite Automation Results: [" + QaProperties.getStack().toUpperCase() + "] [" + percentagePass + " Pass] " + reportTime;
                body = "<html><font face='verdana' size='2'><b>Lyve Suite Automation Run:</b> " + reportTime + "\n\n";
                body += "<b><u>Environment:</b></u>" + "\n";
                body += "Stack: " + QaProperties.getStack().toUpperCase() + "\n";
                body += "Lyve Suite Build #: " + lyvesuitebuildNo + "\n";
                body += "Lyve Suite Browser: " + QaProperties.getBrowser().toUpperCase() + "\n\n";
                body += "<b><u>Test Results</b></u>" + "\n";
                body += testResult + "\n";
                body += "For complete execution details, use the link below:\n" + TestrailURL + "\n\n";
                body += "<b><u>TestRails SignIn:</b></u>\n" + "Username: trguest2@blackpearlsystems.com \nPassword: TRGuestUser2\n </html>";

                reportName = getRailsReportName();
                QaEmail qaEmail = new QaEmail();
                qaEmail.sendEmailAttachment(fromEmail, fromName, toEmail, toName, subject, body, reportScreenshotPath);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            } finally {
                sendFailedEmail();
            }
        }
    }
}