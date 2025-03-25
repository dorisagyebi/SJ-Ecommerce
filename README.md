# Selenium Java Test Automation with TestNG

## Project Overview
This project is a Selenium-based test automation script using TestNG for testing the login functionality and inventory page of the SauceDemo website.

## Technologies Used
- Java
- Selenium WebDriver
- TestNG
- WebDriverManager

## Prerequisites
Ensure you have the following installed before running the project:
- Java (JDK 8 or later)
- Maven or Gradle (optional for dependency management)
- Chrome browser
- WebDriverManager (handles driver setup automatically)

## Setup Instructions
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Open the project in an IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code).
3. Ensure dependencies (TestNG, WebDriverManager, Selenium) are added to your project.
4. Run the test script:
   - Execute the `main` method in `login.java` to perform the tests.

## Test Scenarios
The script performs the following tests:
1. **Login Page Verification**
   - Verifies the presence of the logo and page URL.
   - Logs in using valid credentials.
   - Asserts that the login was successful.

2. **Inventory Page Tests**
   - Counts the total number of items displayed.
   - Retrieves and prints all product names.
   - Extracts and verifies the first and last inventory item names.
   - Finds and displays the top three highest-priced items.

## Running the Tests
- Execute the script from your IDE by running the `main` method in `login.java`.
- The output will display test results in the console.

## Expected Output
- Login should be successful.
- The number of inventory items should be displayed.
- All product names should be listed.
- First and last inventory item names should be validated.
- Top three product prices should be printed.

## Notes
- The script is designed for Chrome but can be modified for other browsers by updating `WebDriverManager`.
- Ensure a stable internet connection when running tests to access `saucedemo.com`.



