#!/bin/sh

#Clean and Assemble the Project
gradle clean assemble

#running a single Testsuite
gradle -Dtest.single=TestPopulateAustralianPlayers test
#./gradlew -Dtest.single=TestAccountSettings test --rerun-tasks

#./gradlew -Dtest.single=TestSignIn test