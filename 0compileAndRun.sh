#!/bin/sh

#Clean and Assemble the Project
./gradlew clean assemble

#Populate the XXXJSON files from Cricbuzz
./gradlew -Dtest.single=TestBuildPlayersFromCricbuzz test

#Insert all the JSON to Cricket.db
./gradlew -Dtest.single=TestDatabaseOperationsV2#populateNow clean test

#upload the Cricket.db to Dropbox
#./gradlew -Dtest.single=TestUploadToDropbox clean test
