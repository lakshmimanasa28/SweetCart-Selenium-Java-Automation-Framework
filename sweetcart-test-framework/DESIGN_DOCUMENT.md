# DESIGN_DOCUMENT.md

# SweetCart Automation Framework Design Document

## Objective

To design a reusable Selenium automation framework for Sweet Shop web application using Page Object Model and TestNG.

---

# Architecture Overview

Framework follows layered design:

```text
Tests Layer
↓
Page Layer
↓
Base Layer
↓
Utilities Layer
↓
Browser / AUT
```

---

# Package Structure

## com.sweetcart.base

### BaseTest.java

Responsibilities:

* Browser Launch
* Driver Setup
* Open Application URL
* Close Browser

### BasePage.java

Responsibilities:

* Common Selenium methods
* click()
* type()
* getText()
* waits

---

## com.sweetcart.pages

### LoginPage.java

Handles:

* Login
* Logout
* Error Messages

### SweetsPage.java

Handles:

* Product Listing
* Basket Actions
* Category Filters

### ProductPage.java

Handles:

* Product Detail Verification

### BasketPage.java

Handles:

* Basket Validation
* Remove Items

### AccountPage.java

Handles:

* Username
* Order History

### NavigationPage.java

Handles:

* Navbar
* About Page
* Footer

---

## com.sweetcart.tests

Contains actual TestNG test classes.

Examples:

* LoginTest
* ProductTest
* BasketTest
* AccountTest
* NavigationTest

---

## com.sweetcart.utils

### ConfigReader.java

Reads values from config.properties

### ScreenshotUtil.java

Captures screenshots on failures

### ExtentReportManager.java

Creates HTML reports

### TestListener.java

Implements ITestListener

---

# Design Patterns Used

## Page Object Model

Separates UI locators from tests.

## Singleton Pattern

Used in ExtentReports manager.

---

# Test Execution Flow

```text
testng.xml
↓
BeforeMethod
↓
Launch Browser
↓
Execute Test
↓
Listener Captures Result
↓
Screenshot on Failure
↓
AfterMethod Close Browser
↓
Generate Report
```

---

# Non Functional Goals

* Maintainability
* Reusability
* Scalability
* Readability
* Less Code Duplication

---

# Future Enhancements

* Parallel Execution
* CI/CD Jenkins Integration
* Excel Driven Testing
* Headless Mode
* Retry Analyzer

---

# Conclusion

Framework successfully automates SweetCart application using industry standard automation architecture.
