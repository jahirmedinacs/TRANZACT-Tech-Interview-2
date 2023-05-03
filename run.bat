@echo off

REM Build the project
mvn clean package

REM Create release folder
mkdir release

REM Move JAR file to release folder
xcopy /y target\Hot-and-Cold-1.0-SNAPSHOT.jar release\

REM Move testCases.csv to release folder
xcopy /y testCases.csv release\

REM Run the JAR file
cd release
java -jar Hot-and-Cold-1.0-SNAPSHOT.jar
cd ..

REM Delete target folder
mvn clean