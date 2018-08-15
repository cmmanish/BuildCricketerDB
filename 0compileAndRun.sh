#!/bin/sh

#Clean and Assemble the Project
./gradlew clean assemble

#Populate the JSON files for each Country
./gradlew -Dtest.single=TestPopulate*Players test

#Insert all the JSON to Cricket.db



#upload the Cricket.db to Dropbox
./gradlew -Dtest.single=TestUploadToDropbox clean test

