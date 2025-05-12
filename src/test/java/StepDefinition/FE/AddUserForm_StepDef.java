package StepDefinition.FE;

import Pages.AddUserFormPage;
import Utils.JsonFileManager;
import io.cucumber.java.en.And;

public class AddUserForm_StepDef {
    String employeeName;
    String userName;
    String password;
    String userRole;
    String status;

    AddUserFormPage addUserForm = new AddUserFormPage();
    JsonFileManager addUserData = new JsonFileManager("src/test/resources/TestData/AddUserData.json");

    @And("user fill {string} data")
    public void userFillData(String userType ) throws InterruptedException {
        employeeName = addUserData.getTestData(userType + ".employeeName");
        userName = addUserData.getTestData(userType + ".username") + System.currentTimeMillis();
        password = addUserData.getTestData(userType + ".password");
        userRole =  addUserData.getTestData(userType + ".userRole");
        status =  addUserData.getTestData(userType + ".status");
        addUserForm.fillAddUserForm(userRole,employeeName,status,userName,password);

    }
    @And("user click on save button")
    public void userClickOnSaveButton() {
        addUserForm.clickSaveButton();
    }


}
