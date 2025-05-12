package StepDefinition.FE;

import Pages.AddUserFormPage;
import Pages.AdminTabPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminTab_StepDef {
    AdminTabPage adminTab = new AdminTabPage();

    int recordsFound;

    @And("user get the number of records found")
    public void userGetTheNumberOfRecordsFound() {
        recordsFound = adminTab.getNumbersOfRecords();
    }

    @When("user click on add user button")
    public void userClickOnAddUserButton() {
        adminTab.clickAddButton();
    }

    @Then("the number of records should be increased by 1")
    public void theNumberOfRecordsShouldBeIncreasedBy() {
        adminTab.assertThatCountIncreasedByOne();
    }

    @When("user search with the just created username")
    public void userSearchWithTheJustCreatedUsername() {
        adminTab.searchWithUserName(AddUserFormPage.CreatedUserName);

    }

    @And("user delete the just created user")
    public void userDeleteTheJustCreatedUser() {
        adminTab.deleteUser();
    }

    @And("user reset the search")
    public void userResetTheSearch() {
        adminTab.resetSearch();
    }

    @Then("the number of records should be decreased by 1")
    public void theNumberOfRecordsShouldBeDecreasedBy() {
        adminTab.assertThatCountDecreasedByOne();
    }
}
