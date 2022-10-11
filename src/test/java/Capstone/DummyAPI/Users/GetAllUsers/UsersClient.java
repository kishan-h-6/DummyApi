package Capstone.DummyAPI.Users.GetAllUsers;

import Capstone.DummyAPI.Users.GetAllUsers.GetAllUserResponse.GetAllUserResponse;
import Capstone.getValidAppId;
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
