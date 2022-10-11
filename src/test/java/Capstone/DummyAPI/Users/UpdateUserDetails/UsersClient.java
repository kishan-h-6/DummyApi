package Capstone.DummyAPI.Users.UpdateUserDetails;

import Capstone.DummyAPI.Users.CreateUserWithDuplicateEmail.CreateUserErrorResponse.CreateUserErrorResponse;
import Capstone.DummyAPI.Users.CreateUserWithDuplicateEmail.UserRequestBody.CreateUserRequestBody;
import Capstone.DummyAPI.Users.GetAllUsers.GetAllUserResponse.GetAllUserResponse;
import Capstone.DummyAPI.Users.UpdateUserDetails.UpdateUserRequestBody.UpdateUserRequestBody;
import Capstone.getValidAppId;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class UsersClient {

    public Response update(UpdateUserRequestBody body){
        return given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("app-id", "633c1299e9593a1f5e8b8758")
                    .body(body)
                .log().body()
                .when()
                     .put("https://dummyapi.io/data/v1/user/60d0fe4f5311236168a109f0");
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
