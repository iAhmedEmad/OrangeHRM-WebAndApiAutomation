package StepDefinition.API;

import Services.CandidateService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Canditate_StepDef {

    Response response;
    CandidateService candidateService = new CandidateService();

    @When("user send request to add new candidate")
    public void userSendRequestToAddNewCandidate() {
        response = candidateService.addNewCandidate("ahmed","emad","gfhgh","asddf@sdgfg.com",2);
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
