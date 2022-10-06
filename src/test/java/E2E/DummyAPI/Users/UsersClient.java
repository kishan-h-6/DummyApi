package E2E.DummyAPI.Users;

import E2E.DummyAPI.Users.UserRequestBody.CreateUserRequestBody;
import E2E.getValidUserId;
import User.getValidAppId;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class UsersClient {
    public Response createUser(CreateUserRequestBody body){
        return given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("app-id", "633c1299e9593a1f5e8b8758")
                    .body(body)
                .when()
                     .post("https://dummyapi.io/data/v1/user/create");
    }
    public Response getAllUsers(){
        return given()
                .header("app-id", getValidAppId.ValidAppId)
                .when()
                .get("https://dummyapi.io/data/v1/user?limit=10");
    }
    public Response getAllUserUnderYourAccount(){
        return given()
                .header("app-id", getValidAppId.ValidAppId)
                .when()
                .get("https://dummyapi.io/data/v1/user?created=1");
    }

    public Response deleteUserById(String userId){

        return given()
                .header("app-id", getValidAppId.ValidAppId)
                .when()
                .delete("https://dummyapi.io/data/v1/user/"+ userId);
    }
}
