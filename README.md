#!/bin/sh

#!/bin/sh

#Clean and Assemble the Project
./gradlew clean assemble

#running a single Testsuite
./gradlew -Dtest.single=TestPopulateJSON test
#./gradlew -Dtest.single=TestAccountSettings test --rerun-tasks

#./gradlew -Dtest.single=TestSignIn test