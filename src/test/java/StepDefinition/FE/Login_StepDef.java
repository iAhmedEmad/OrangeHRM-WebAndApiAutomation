package StepDefinition.FE;

import Pages.LoginPage;
import Utils.JsonFileManager;
import io.cucumber.java.en.Given;
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



}
