package StepDefinition;

import Utils.JsonFileManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import Pages.LoginPage;
public class Login_StepDef {

    String password;
    String userName;

    private LoginPage loginPage = new LoginPage();

    JsonFileManager userData = new JsonFileManager("src/test/resources/TestData/LoginData.json");

    @Given("{string} login successfully")
    public void loginSuccessfully(String userType) {
        userName = userData.getTestData(userType + ".username");
        password = userData.getTestData(userType + ".password");
        loginPage.userLogin(userName,password);

    }
    @When("user click on Admin tab on the left side menu")
    public void userClickOnAdminTabOnTheLeftSideMenu() {
        
    }

    @And("Get the number of records found")
    public void getTheNumberOfRecordsFound() {
    }

    @And("Click on add button")
    public void clickOnAddButton() {
    }



}
