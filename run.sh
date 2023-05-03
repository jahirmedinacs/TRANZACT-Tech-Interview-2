#! /bin/bash

# Build the project
mvn clean package

# create release folder
mkdir -p release

# move jar file to release folder
cp target/Hot-and-Cold-1.0-SNAPSHOT.jar release/

# move testCases.csv to release folder
cp testCases.csv release/

# run the jar file
cd release || exit
java -jar ./Hot-and-Cold-1.0-SNAPSHOT.jar --demo
cd .. || exit

# delete target folder
mvn clean