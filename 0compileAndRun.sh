#!/bin/sh

#Clean and Assemble the Project
./gradlew clean assemble

#Populate the JSON files for each Country
./gradlew -Dtest.single=TestBuildPlayersFromCricbuzz test

#Insert all the JSON to Cricket.db
./gradlew -Dtest.single=TestPopulateDatabase#populateNow clean test

#upload the Cricket.db to Dropbox
./gradlew -Dtest.single=TestUploadToDropbox clean test