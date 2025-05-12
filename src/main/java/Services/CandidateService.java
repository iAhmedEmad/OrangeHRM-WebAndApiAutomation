package Services;

import Pages.LoginPage;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class CandidateService {

    RequestSpecification rs;
    public static int createdCandidateId;
    String sessionCookie = LoginPage.getSessionCookieValue();

    public CandidateService() {
         rs  = given().baseUri("https://opensource-demo.orangehrmlive.com")
                .basePath("/web/index.php/api/v2/recruitment/candidates")
                 .header("cookie", sessionCookie)
                 .contentType(ContentType.JSON);
    }

     // Add Candidate
    private String setPOSTRequestBody(String firstName, String middleName, String lastName, String email, int contactNumber){
        return """
                {
                "firstName": "$firstName",
                "middleName": "$middleName",
                "lastName": "$lastName",
                "email": "admin@fdfd.com",
                "contactNumber": "$contactNumber",
                "keywords": "",
                "comment": "",
                "dateOfApplication": "2025-05-10",
                "consentToKeepData": false
            }
    """.replace("$firstName", String.valueOf(firstName))
                .replace("$firstName", String.valueOf(firstName))
                .replace("$middleName", String.valueOf(middleName))
                .replace("$lastName", String.valueOf(lastName))
                .replace("$email", String.valueOf(email))
                .replace("$contactNumber", String.valueOf(contactNumber));
    }

    public Response addNewCandidate(String firstName, String middleName, String lastName, String email, int contactNumber) {
        Response response = given()
                .spec(rs)
                .body(setPOSTRequestBody(firstName, middleName, lastName, email, contactNumber))
                .log().all()
                .when()
                .post();

        // Extract ID from response
        createdCandidateId = response.then().log().all()
                .extract()
                .path("data.id");

        System.out.println("Created Candidate ID: " + createdCandidateId);

        return response;
    }

    public int getCreatedCandidateId() {
        return createdCandidateId;
    }

    // Delete Candidate
    private String setDeleteRequestBody(int id){
        return """
                {
                    "ids": [
                        $ID
                    ]
                }
    """.replace("$ID", String.valueOf(id));
    }

    public void deleteCandidate(int id) {
        given()
                .spec(rs)
                .body(setDeleteRequestBody(id))
                .log().all()
                .when()
                .delete()
                .then()
                .log().all()
                .statusCode(200);
    }
}



