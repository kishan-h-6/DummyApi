package Capstone.DummyAPI.Users.DeleteUser;
import User.getValidAppId;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class UsersClient {
    public Response getAllUsers(){
        Response response = given()
                .header("app-id", getValidAppId.ValidAppId)
                .when()
                .get("https://dummyapi.io/data/v1/user?limit=10");
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
