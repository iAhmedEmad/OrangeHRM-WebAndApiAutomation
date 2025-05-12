package Pages;

import Hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class LoginPage{

    WebDriver driver;
    private static String sessionCookie;

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
        // After login, extract the session cookie
        Cookie sessionCookieValue = driver.manage().getCookieNamed("orangehrm");
        sessionCookie = String.valueOf(sessionCookieValue);
        if (sessionCookie != null) {
            System.out.println("Session Cookie Value: " + sessionCookie);
        } else {
            System.out.println("Session cookie not found.");
        }
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

    public static String getSessionCookieValue() {
        return sessionCookie;
    }
    // validations \\
}
