# AmazonScenarioAutomation

## Basic Design:
The project is designed using Java with Maven. All global configurations are living inside the properties files (resources/configfiles/config.properties). It gives you the possibility to edit the global project behaviour in one place without altering the project/setup specific code. Furthermore all properties can be overridden via system properties.

| Project Structure | Dependencies              |
| ------------------| --------------------------|
| Base              | Selenium Webdriver        |
| Utilities         | Test NG                   |
| TestCase          | Report NG                 |

## Prerequisites
* JDK14 installed
* Eclipse Version: 2022-03 (4.23.0)
* Apache Maven 3.8.5
* Test NG Plugin installed in Eclipse

## Dependencies
Maven is used to manage all the dependencies in the project. All the dependencies are defined in the pom.xml file which can easily be accessed in the root directory of the project.

##  Implemented Browsers
The project supports testing on multiple browsers. However, the project scope is limited to running on Google Chrome and Firefox at this moment. This scope can be expanded for other browsers as well.

## Features:
* Muliple Browser Support
* Efficient page layer management - Page Factory Pattern Design
* Helper methods for page interactions
* Control by Annotations
* Pretty and highly readable test reports
* Centralized project config
* assertions, waits and test extensions
* Platform independent
* Execution using Testng.xml/ Maven through CMD

##  Modules Understanding
There are 5 packages defined in the project. Each package serves a different pupose 

* src/test/java/base - This package sets up all the evnironment variables and browser settings before initiating the tests. On the successful execution of tests it also tears down the connections and files opened during the execution.
* src/test/java/objectrepository - This package manages all the locators that are being used in the project.
* src/test/java/testcases - This package mantains the test script/scripts and is responsible for the overall test execution flow.
* src/test/java/utility - This package maintains all the helper methods/reusable code being repetedly with in the project.
* src/test/java/resources - This package maintains the listener class.

## Test Execution
* Execution using testng.xml file- The test can simply be executed by using the ".\testng.xml" file. Right click the file and choose "run as Test NG Suite". The final assertion confirmation message gets printed in the console. 
* Execution using Maven using CMD- Using CMD go to the path where the project is saved. Once you are in the project directory, execute "mvn test" and wait for the execution to finish.

## Reports
Report NG has been integrated in the project for better test reports. It supports various features like graphical reports, suite level reports, test level reports etc.

After the test execution, kindly refresh the project folder and access the test report from the "./test-output/html/index.html" file. The report can simply be opened in a browser tab by choosing the "open in a browser" option from the right click menu.
