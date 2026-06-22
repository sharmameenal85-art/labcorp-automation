# LabCorp Automation Framework

## Overview

This project contains automated test solutions developed as part of the LabCorp QA Automation assessment. The framework is built using Java, Selenium WebDriver, Cucumber (BDD), Maven, and JUnit.

The automation suite covers:

1. UI Automation using Selenium WebDriver and Cucumber
2. API Automation using Rest Assured and Cucumber
3. Test reporting and execution through Maven

---

## Technology Stack

* Java 21
* Selenium WebDriver
* Cucumber BDD
* JUnit 5
* Rest Assured
* Maven
* WebDriverManager

---

## Project Structure

```text
src
 ├── test
 │   ├── java
 │   │    ├── runners
 │   │    ├── stepdefinitions
 │   │    ├── pages
 │   │    ├── hooks
 │   │    └── utils
 │   └── resources
 │        └── features
 └── pom.xml
```

---

## Test Scenarios

### UI Automation

Validate navigation from LabCorp homepage to Careers and verify a specific job posting.

Coverage includes:

* Navigate to [www.labcorp.com](http://www.labcorp.com)
* Access Careers section
* Search for a target job posting
* Validate job title
* Validate location
* Validate job description details

### API Automation

Validate customer information from API response.

Coverage includes:

* Send API request
* Validate response status code
* Validate customer name
* Validate customer email
* Validate order ID
* Validate response schema and required fields

---

## Running Tests

### Run All Tests

```bash
mvn clean test
```

### Run UI Tests

```bash
mvn test -Dcucumber.filter.tags="@UI"
```

## Reporting

After execution, test reports can be found under:

```text
target/
```

Generated reports include:

* Cucumber Reports
* Maven Surefire Reports

---

## Design Approach

The framework follows:

* Page Object Model (POM)
* BDD using Cucumber
* Reusable utility classes
* Separation of test data and test logic
* Maintainable and scalable automation design

---

## Author

Meenal Sharma

QA Automation Engineer
