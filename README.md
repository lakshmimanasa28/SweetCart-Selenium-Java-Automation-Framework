# README.md

# SweetCart Selenium Java Automation Framework

## Project Overview

SweetCart is a Selenium WebDriver automation testing framework developed using Java, TestNG, Maven, and Page Object Model (POM).

The framework automates end-to-end test scenarios for the Sweet Shop demo web application:

https://sweetshop.netlify.app

## Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* WebDriverManager
* Extent Reports
* Apache Commons IO

## Framework Features

* Page Object Model (POM)
* Data Driven Login Tests using DataProvider
* Cross Browser Support
* Configurable via properties file
* Screenshot Capture on Failure
* Extent HTML Reports
* Reusable Base Classes
* Clean Package Structure

## Application Modules Covered

### User Authentication

* Valid Login
* Invalid Login
* Multiple User Login Validation

### Product Module

* Product Listing Validation
* Add to Basket Button Validation

### Basket Module

* Add Product to Basket
* Multiple Products Add
* Remove Product
* Basket Count Validation

### Account Module

* Username Validation
* Order History Validation

### Navigation Module

* Navbar Links Validation
* About Page Validation
* Footer Validation

## Project Structure

src/main/java

* com.sweetcart.base
* com.sweetcart.pages

src/test/java

* com.sweetcart.tests
* com.sweetcart.utils

src/test/resources

* config.properties

reports

* ExtentReport.html

screenshots

* Failure screenshots

## How To Run Project

### Using Eclipse

* Right click testng.xml
* Run As TestNG Suite

### Using Maven

```bash
mvn test
```

## Test Report

After execution:

```text
reports/ExtentReport.html
```

## Screenshots

Failed test screenshots saved inside:

```text
screenshots/
```

## Author

SweetCart Automation Project
