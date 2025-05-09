package Pages;

import Hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddUserFormPage {
    WebDriver driver;
    Actions actions;
    public static String CreatedUserName;

    // Constructor \\
    public AddUserFormPage() {
        this.driver = Hooks.getDriver();
        actions = new Actions(driver);
    }

    // Locators \\
            //Form input Fields Locators\\
    private By userRoleDropDown = By.xpath("(//div[@class='oxd-select-text--after'])[1]");
    private By employeeNameLocator = By.xpath("//input[@placeholder='Type for hints...']");
    private By statusLocator = By.xpath("(//div[@class='oxd-select-text--after'])[2]");
    private By userNameLocator = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private By passwordLocator = By.xpath("(//input[@type='password'])[1]");
    private By confirmPassword = By.xpath("(//input[@type='password'])[2]");

             //Form Buttons Locators\\
    private By saveButton = By.xpath("//button[@type='submit']");


    // Actions \\
    public void fillAddUserForm(String userRole, String employeeName, String status, String userName, String password) throws InterruptedException {
        CreatedUserName = userName;
        // User Role
        selectUserRole(userRole);
        // Employee Name
        selectEmployeeName(employeeName);
        // Status
        selectStatus(status);
        // Username
        driver.findElement(userNameLocator).sendKeys(userName);
        // Password
        driver.findElement(passwordLocator).sendKeys(password);
        // Confirm Password
        driver.findElement(confirmPassword).sendKeys(password);
    }

    public void clickSaveButton(){
        driver.findElement(saveButton).click();
    }

            // Helper Action Methods
     private void selectUserRole(String userRole) {
        driver.findElement(userRoleDropDown).click();
        switch (userRole) {
            case "Admin":
                actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
                break;
            case "ESS":
                actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();break;
                default:
                    throw new IllegalArgumentException("Invalid user role: " + userRole);
                }
            }

    private void selectStatus(String status) {
        driver.findElement(statusLocator).click();
        switch (status) {
            case "Enabled":
                actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
                break;
            case "Disabled":
                actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
                break;
            default:
                throw new IllegalArgumentException("Invalid status: " + status);
        }
    }

    private void selectEmployeeName(String employeeName){
        driver.findElement(employeeNameLocator).sendKeys(employeeName);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class='oxd-input-group.oxd-input-field-bottom-space']")
            ));
        } catch (Exception ignored) {
        }
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }
    // validations \\

}
