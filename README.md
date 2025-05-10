# OrangeHRM-WebAutomation

# Selenium & Cucumber - GUI Test Automation Demo Project


## 🧪 Tools & Technologies

- **Java**
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **TestNG**
- **Maven**
- **Cucumber HTML Reports**


## Project Design:
- Modular Design Using Page Object Model Design Pattern (POM)
  -  Page classes contains:
      - Locators
      - Actions
      - Validations (Assertions)
     
- Cucumber Feature Files & Step Definition Files
  - Feature Files contains The Test Cases in Gherkin Language (Given, When, Then)
  - Step Definition Files Link Feature Files with The Page Classes 

- Externalizing Test Data From JSON File


## 📊 Reporting:
This project uses Cucumber's built-in HTML report to display test execution results.

📍 Location: 
The report is generated at: target/cucumber-reports.html

🚀 Auto-Open Feature:
After running the tests using: mvn clean verify
the report will automatically open in your default browser — even if some test cases fail.

🧠 This is achieved by combining:
1- exec-maven-plugin to open the HTML file
2- maven-surefire-plugin with: <testFailureIgnore>true</testFailureIgnore>
to allow the build to continue and reach the verify phase (where the report is opened)

🖱️ You can also open the report manually by navigating to: target/cucumber-reports.html
