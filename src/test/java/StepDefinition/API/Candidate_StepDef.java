package StepDefinition.API;

import Services.CandidateService;
import Utils.JsonFileManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Candidate_StepDef {

    Response response;
    String firstName;
    String middleName;
    String lastName;
    String email;
    String contactNumber;

    JsonFileManager addCandidateData = new JsonFileManager("src/test/resources/TestData/AddCandidateData.json");
    CandidateService candidateService = new CandidateService();

    @When("user send request to add  {string}")
    public void userSendRequestToAdd(String candidate) {
        firstName = addCandidateData.getTestData(candidate + ".firstName");
        middleName = addCandidateData.getTestData(candidate + ".middleName");
        lastName = addCandidateData.getTestData(candidate + ".lastName");
        email = addCandidateData.getTestData(candidate + ".email");
        contactNumber = addCandidateData.getTestData(candidate + ".contactNumber");

        response = candidateService.addNewCandidate(firstName,middleName,lastName,email,contactNumber);
    }


    @When("user send request to delete new candidate")
    public void userSendRequestToDeleteNewCandidate() {
        candidateService.deleteCandidate(candidateService.getCreatedCandidateId());
    }

    @Then("api should success with response code {int}")
    public void apiShouldSuccessWithResponseCode(int statusCode) {
        assertThat("Status code should be 200", response.statusCode(), equalTo(statusCode));
    }


}
