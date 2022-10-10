package E2E.DummyAPI.Users.GetAllUsers;

import E2E.DummyAPI.Users.CreateUserWithDuplicateEmail.CreateUserErrorResponse.CreateUserErrorResponse;
import E2E.DummyAPI.Users.GetAllUsers.GetAllUserResponse.GetAllUserResponse;
import E2E.DummyAPI.Users.GetAllUserUnderYourAccount.GetAllUsersCreatedByAccount.GetAllUserCreatedByAccountResponse;
import User.getValidAppId;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class UsersClient {
    public GetAllUserResponse getAllUser(){
        Response response = getAllUsers();
        GetAllUserResponse allUserResponse=response.as(GetAllUserResponse.class);
        return allUserResponse;
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

}
