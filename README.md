# 🖥️ Cucumber BDD Test Framework

## 📖 Overview

This repository contains a Cucumber BDD-based Test Automation Framework built using Java, Selenium WebDriver, and TestNG. It supports Behavior-Driven Development (BDD) for web application testing, enabling collaboration between technical and non-technical stakeholders through human-readable feature files. The framework is modular, scalable, and maintainable, with a clear separation of concerns. It integrates custom services, utility classes, page components, and step definitions, and supports both UI and API testing, data-driven testing, and service layer validation, making it adaptable for a wide range of automation projects.

---

## ✨ Key Features

🧪 **Behavior-Driven Development (BDD)** with Cucumber and Gherkin syntax  
⚙️ **Modular Page Object Model (POM)** for UI automation  
🔄 **Data-Driven Testing** using Excel and Custom DataTable Mappers  
🔗 **Service Layer Support** for API interaction and validation  
🔍 **Custom Parameter & Data Table Type Bindings** for reusable step logic  
🧩 **Hooks and Context Management** for clean stateful execution  
📸 **Screenshot Capture and Logging** integrated with step failures  
📊 **Advanced Reporting** using ExtentReports  
🔧 **Multiple Environments** via `stage.properties`, `prod.properties`  
🚀 **TestNG and Cucumber CLI Runners** for flexible execution  
🌐 **Selenium WebDriver** for automated browser interaction  
🔐 **AES Encryption** for encryption and decryption of sensitive data  

---

## 🔧 Prerequisites

Before running the framework, ensure the following tools are installed on your system:

✅ Java 11 or higher  
✅ Maven (for dependency management)  
✅ IDE (e.g., IntelliJ IDEA, Eclipse)  

---

## 🚀 Getting Started

Follow the steps below to set up and execute your tests using the **Cucumber BDD Test Framework**.

---

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/JagatheshwaranN/CucumberBDDTestFramework.git
```

---

### 2️⃣ Set Up the Project

Navigate to the project directory and run the following Maven command:

```bash
mvn clean install
```

This will download all required dependencies and compile the project.

---

### 3️⃣ Run Tests

You can execute your tests using Maven with custom parameters:

```bash
mvn test -DBrowser=Chrome -DRunType=Local -Dorg.freemarker.loggerLibrary=NONE -DFULL_PAGE_SCREENSHOT=No
```

**Parameters:**
- `Browser` → Specify the browser (e.g., Chrome, Firefox)  
- `RunType` → Choose between Local or Remote execution  
- `FULL_PAGE_SCREENSHOT` → Enable/Disable full-page screenshot capture  

---

### 4️⃣ Generating Reports

📁 Reports and logs will be auto-generated after test execution:

✅ **Cucumber HTML Report** → `/target/cucumber`  
✅ **ExtentReports HTML Report** → `/target/reports`  
✅ **TestNG HTML Report** → `/target/surefire-reports`  
✅ **Screenshots for failed steps** → `/resources/screenshots`  
✅ **Detailed Cucumber HTML Report** → `/target/cucumber-html-reports`  

> 🔔 **Note:**  
> To generate the **Detailed Cucumber Report**, use the following command:
>
> ```bash
> mvn verify
> ```
> instead of:
> ```bash
> mvn test
> ```

---

## 🤝 Contributions

Feel free to fork the repository, raise issues, or submit pull requests to enhance the framework further!

---

## 🧑🏻 Maintainer

Built and maintained with ❤️ by **Jagatheshwaran N**  
GitHub: [@JagatheshwaranN](https://github.com/JagatheshwaranN)

---

## 📜 License

This project is open-sourced under the [MIT License](LICENSE).

---

## 📁 Directory Structure

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
│       │   ├── prod.properties
│       │   └── stage.properties
│       ├── data/
│       │   └── testData.xlsx
│       ├── features/
│       │   ├── AddToCartOnStore.feature
│       │   ├── LoginToStore.feature
│       │   ├── PlaceOrderAsGuest.feature
│       │   ├── PlaceOrderAsGuestByService.feature
│       │   └── PlaceOrderWithExcelDataAsGuest.feature
│       ├── logs/
│       │   └── AutomationExecution.log
│       ├── screenshots/
|       |   └── 19_03_2025_11_21_07.png
│       ├── xml/
│       |   └── testNG.xml
│       ├── extent.properties
│       ├── cucumber.properties
│       ├── html-config.xml
│       ├── pdf-config.yaml
│       └── spark-config.xml
└── pom.xml
