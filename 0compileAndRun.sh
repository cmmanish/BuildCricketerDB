#!/bin/sh

#Clean and Assemble the Project
./gradlew clean assemble

#running a single Testsuite
./gradlew -Dtest.single=TestPopulate*Players test


#./gradlew -Dtest.single=TestPopulateAustralianPlayers clean test