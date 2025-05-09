package Pages;

import Hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainMenuPage {

    WebDriver driver;

    // Constructor \\
    public MainMenuPage() {
        this.driver = Hooks.getDriver();
    }

    // Locators \\
    private By adminTab = By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]");

    // Actions \\
    public void navigateToAdminTab(){
        driver.findElement(adminTab).click();
    }

    // validations \\

}
