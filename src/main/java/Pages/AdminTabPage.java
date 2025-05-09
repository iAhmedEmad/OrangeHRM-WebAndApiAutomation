package Pages;

import Hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AdminTabPage {

    WebDriver driver;
    int recordsFoundNumber;

    // Constructor \\
    public AdminTabPage() {
        this.driver = Hooks.getDriver();
    }

    // Locators \\
    private By numberOfRecordsFound = By.xpath("//span[@class='oxd-text oxd-text--span']");
    private By addButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    private By userName = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private By searchButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    private By deleteIcon = By.xpath("//i[@class='oxd-icon bi-trash']");
    private By deletePopUp_Confirm = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']");
    private By resetButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--ghost']");



    // Actions \\
    public int getNumbersOfRecords(){
        String recordsFound = (driver.findElement(numberOfRecordsFound).getText());
        recordsFound = recordsFound.replaceAll("[^0-9]", ""); // removes everything that's not a digit
        recordsFoundNumber = Integer.parseInt(recordsFound);   // convert to int
        return recordsFoundNumber;
    }
    public void clickAddButton(){
        driver.findElement(addButton).click();
    }
    public void searchWithUserName(String createdUserName){
        driver.findElement(userName).sendKeys(createdUserName);
        driver.findElement(searchButton).click();
    }
    public void deleteUser(){
        driver.findElement(deleteIcon).click();
        driver.findElement(deletePopUp_Confirm).click();
    }
    public void resetSearch(){
        driver.findElement(resetButton).click();
    }

    // validations \\
    public void assertThatCountIncreasedByOne(){
        int expectedNewCount = recordsFoundNumber + 1;
        int actualCount = getNumbersOfRecords();
        Assert.assertEquals(actualCount,expectedNewCount);
    }
    public void assertThatCountDecreasedByOne(){
        int expectedNewCount = recordsFoundNumber - 1;
        int actualCount = getNumbersOfRecords();
        Assert.assertEquals(actualCount,expectedNewCount);
    }
}
