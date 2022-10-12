package Capstone.DummyAPI.E2E;

import Capstone.DummyAPI.E2E.UserRequestBody.CreateUserRequestBody;
import Capstone.DummyAPI.Users.CreateUserWithEmail.CreateUserErrorResponse.CreateUserErrorResponse;
import Capstone.getValidAppId;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class UsersClient {

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
