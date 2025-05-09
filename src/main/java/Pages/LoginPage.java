package Pages;

import Hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage{

    WebDriver driver;

    // Constructor \\
    public LoginPage() {
        this.driver = Hooks.getDriver();
    }

    // Locators \\
    private By userNameLocator = By.xpath("//input[@name='username']");
    private By passwordLocator = By.xpath("//input[@name='password']");
    private By loginButton = By.xpath("//button[@type='submit']");



    // Actions \\
    public void userLogin(String userName, String passWord){
        enterUserName(userName);
        enterPassword(passWord);
        clickLogin();
    }

    // Helper Action Methods
    private void enterUserName (String nameName){
        driver.findElement(userNameLocator).sendKeys(nameName);
    }
    private void enterPassword (String password){
        driver.findElement(passwordLocator).sendKeys(password);
    }
    private void clickLogin (){
        driver.findElement(loginButton).click();
    }


    // validations \\
}
