# Cucumber BDD Test Framework

## Overview
This repository contains a Cucumber BDD-based Automation Framework built using Java, Selenium WebDriver, and TestNG, designed to support 
Behavior-Driven Development (BDD) for web application testing. The framework promotes collaboration between technical and non-technical 
stakeholders through human-readable feature files, while maintaining powerful and flexible backend automation logic.

The framework is scalable, maintainable, and designed with separation of concerns in mind. It integrates custom services, page components, 
utility classes, and step definitions, making it adaptable to a wide range of web testing projects.

## 🔑 Key Features
🧪 Behavior-Driven Development (BDD) with Cucumber and Gherkin syntax

🌐 Selenium WebDriver for robust and flexible automated browser interaction

⚙️ Modular Page Object Model (POM) for scalable and maintainable UI automation

🔄 Data-Driven Testing using Excel sheets and Custom DataTable Mappers

🔗 Service Layer Support for REST API interaction and validation

🔍 Custom Parameter & Data Table Type Bindings for reusable and readable step definitions

🧩 Hooks and Context Management to maintain clean, isolated test execution states

📸 Screenshot Capture and detailed logging automatically integrated with test failures

📊 Advanced Reporting using ExtentReports with support for HTML, PDF, and Spark themes

🔧 Multi-environment configuration support via stage.properties, prod.properties, etc.

🚀 Flexible test execution using both TestNG and Cucumber CLI runners

🔐 AES encryption and decryption of sensitive data for secure test execution


## ⚙️ Prerequisites
Before getting started with the Cucumber BDD Test Framework, ensure the following tools and technologies are installed and properly 
configured in your local environment:

☕ Java 11 or higher – Required to compile and run the automation framework

📦 Maven – For managing dependencies, plugins, and lifecycle

🧠 IDE – Recommended: IntelliJ IDEA or Eclipse for better code navigation and debugging support

🌐 Internet Connectivity – To download Maven dependencies during the first build

💻 Web Browsers – Chrome, Firefox, or Edge


## Getting Started

### 1. Clone the Repository
To get started with the framework, first clone the repository:

```bash
https://github.com/JagatheshwaranN/CucumberBDDTestFramework.git
```

### 2. Set Up the Project
The project is managed by Maven. To download all necessary dependencies, navigate to the project directory and run:
``` bash
mvn clean install
```
### 3. Run Tests
Alternatively, you can run specific TestNG XML suites for targeted test execution:
``` bash
 mvn test -DsuiteXmlFile='testng.xml' -'Dorg.freemarker.loggerLibrary=NONE'
```
### 4. Generating Reports
- Extent will generate an HTML report in the ```/resources/report``` directory after test execution.
- TestNG will automatically generate an HTML report in the ```/test-output``` directory after test execution.
- Additionally, screenshots will be captured for any failed test and stored in the ```/resources/screenshots``` folder.

## Directory Structure

```plaintext
CucumberBDDTestFramework/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── qa/
│   │   │           └── ctf/
│   │   │               ├── base/
│   │   │               │   ├── ElementActions
│   │   │               │   ├── Page
│   │   │               │   └── PageComponent
│   │   │               ├── constant/
│   │   │               │   ├── BrowserType
│   │   │               │   ├── RunType
│   │   │               │   └── TestConstants
│   │   │               ├── context/
│   │   │               │   └── TestContext
│   │   │               ├── factory/
│   │   │               │   ├── BrowserFactory
│   │   │               │   ├── DriverFactory
│   │   │               │   └── RunFactory
│   │   │               ├── handler/
│   │   │               │   ├── AlertHandler
│   │   │               │   ├── BrowserHandler
│   │   │               │   ├── DateTimeHandler
│   │   │               │   ├── DropDownHandler
│   │   │               │   ├── InteractionHandler
│   │   │               │   ├── JavaScriptHandler
│   │   │               │   ├── VerificationHandler
│   │   │               │   └── WaitHandler
│   │   │               ├── hook/
│   │   │               │   └── TestHook
│   │   │               ├── service/
│   │   │               │   ├── CookieMapper
│   │   │               │   ├── ServiceRequest
│   │   │               │   └── SpecBuilder
│   │   │               └── util/
│   │   │                   ├── EncryptionManager
│   │   │                   ├── ExcelReader
│   │   │                   ├── ExceptionHub
│   │   │                   ├── FileReader
│   │   │                   └── ScreenCapture
│   └── resources/
│       ├── config/
│       │   ├── prod.properties
│       │   └── stage.properties
│       └── log4j2.properties
├── test/
│   ├── java/
│   │   └── com/
│   │       └── qa/
│   │           └── ctf/
│   │               └── app/
│   │                   ├── Cookies
│   │                   ├── CustomDataTableType
│   │                   ├── CustomParameterType
│   │                   ├── base/
│   │                   │   ├── PageBase
│   │                   │   └── PageFactory
│   │                   ├── constant/
│   │                   │   ├── Endpoint
│   │                   │   └── Message
│   │                   ├── context/
│   │                   │   └── AppContext
│   │                   ├── domain/
│   │                   │   ├── BillingDetails
│   │                   │   ├── ExcelDataToDataTable
│   │                   │   └── Product
│   │                   ├── objects/
│   │                   │   ├── AccountPageObject
│   │                   │   ├── CartPageObject
│   │                   │   ├── CheckoutPageObject
│   │                   │   ├── LoginPageObject
│   │                   │   └── StorePageObject
│   │                   ├── pages/
│   │                   │   ├── AccountPage
│   │                   │   ├── CartPage
│   │                   │   ├── CheckoutPage
│   │                   │   ├── LoginPage
│   │                   │   └── StorePage
│   │                   ├── runner/
│   │                   │   └── TestNGRunnerTest
│   │                   ├── service/
│   │                   │   └── CartService
│   │                   └── steps/
│   │                       ├── BaseSteps
│   │                       ├── CartSteps
│   │                       ├── CheckoutSteps
│   │                       ├── CustomerSteps
│   │                       ├── LoginSteps
│   │                       └── StoreSteps
│   └── resources/
│       ├── config/
│       │   ├── extent.properties
│       │   ├── cucumber.properties
│       │   └── xml/
│       │       ├── testNG.xml
│       │       ├── html-config.xml
│       │       ├── pdf-config.yaml
│       │       └── spark-config.xml
│       ├── data/
│       │   └── testData.xlsx
│       ├── features/
│       │   ├── AddToCartOnStore.feature
│       │   ├── LoginToStore.feature
│       │   ├── PlaceOrderAsGuest.feature
│       │   ├── PlaceOrderAsGuestByService.feature
│       │   └── PlaceOrderWithExcelDataAsGuest.feature
│       ├── logs/
│       │   ├── AutomationExecution.log
│       └── screenshots/
|           └── 19_03_2025_11_21_07.png
└── pom.xml
