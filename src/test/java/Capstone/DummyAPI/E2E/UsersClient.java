package Capstone.DummyAPI.E2E;

import Capstone.DummyAPI.E2E.UserRequestBody.CreateUserRequestBody;
import Capstone.DummyAPI.Users.CreateUserWithDuplicateEmail.CreateUserErrorResponse.CreateUserErrorResponse;
import Capstone.getValidAppId;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class UsersClient {
    public CreateUserErrorResponse createUserExpectingError(CreateUserRequestBody body){
        Response response = create(body);
        CreateUserErrorResponse errorResponse = response.as(CreateUserErrorResponse.class);
        return errorResponse;
    }

    public Response create(CreateUserRequestBody body){
        return given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("app-id", "633c1299e9593a1f5e8b8758")
                    .body(body)
                .when()
                .log().body()
                     .post("https://dummyapi.io/data/v1/user/create")
                ;
    }
    public Response getAllUsers(){
        Response response = given()
                .header("app-id", getValidAppId.ValidAppId)
                .when()
                .get("https://dummyapi.io/data/v1/user?limit=10");

        response.then()
                .log().body();
        return response;
    }

    public Response deleteUserById(String userId){
        Response response = given()
                .header("app-id", getValidAppId.ValidAppId)
                .when()
                .delete("https://dummyapi.io/data/v1/user/"+ userId);
        response.then()
                .log().body();
        return response;
    }
}
