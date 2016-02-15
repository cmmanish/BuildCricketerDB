package com.cricket.stats.appium;

import org.apache.log4j.Logger;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mmadhusoodan on 4/6/15.
 */
public class AvailabelPorts {
    public static Logger log = Logger.getLogger(AvailabelPorts.class);

    public List<String> getUsedPorts() {

        Socket Skt;
        String host = "localhost";
        List<String> portList = new ArrayList<String>();
        for (int i = 4700; i < 4750; i++) {
            try {
                Skt = new Socket(host, i);
                //log.info(Skt.getPort());
//                log.info("There is a server on port " + i + " of " + host);
                portList.add(Integer.toString(Skt.getPort()));

            } catch (UnknownHostException e) {
                log.info("Exception occured" + e);
                break;
            } catch (IOException e) {
            }
        }
        return portList;
    }

    public String getPort() {
        String port = "";
        try {
            for (int iport = 4700; iport <= 4800; iport++) {
                try {
                    ServerSocket socket = new ServerSocket(iport);
                    socket.setReuseAddress(false);
                    port = Integer.toString(socket.getLocalPort());
                    socket.close();
                    if (!isPortUsed(port))
                        break;
                    //return port;
                } catch (IOException e) {
                    // try the next port
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return port;
    }

    public boolean isPortUsed(String port) {

        List<String> portList = getUsedPorts();
        if (portList.contains(port))
            return true;
        else
            return false;
    }

    public static void main(String Args[]) {

        AvailabelPorts availabelPorts = new AvailabelPorts();
        log.info("usedPorts: " + availabelPorts.getUsedPorts());
        log.info(availabelPorts.getPort());
    }
}