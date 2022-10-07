package E2E.DummyAPI.Users;

import E2E.DummyAPI.Users.CreateUserErrorResponse.CreateUserErrorResponse;
import E2E.DummyAPI.Users.CreateUserResponse.CreateUserResponse;
import E2E.DummyAPI.Users.GetAllUserResponse.GetAllUserResponse;
import E2E.DummyAPI.Users.UserRequestBody.CreateUserRequestBody;
import E2E.getValidUserId;
import User.getValidAppId;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class UsersClient {

    public CreateUserResponse createUser(CreateUserRequestBody body){
    Response response=create(body);
    CreateUserResponse createUserResponse=response.as(CreateUserResponse.class);
    return createUserResponse;
    }

    public CreateUserErrorResponse createUserExpectingError(CreateUserRequestBody body){
        Response response=create(body);
        CreateUserErrorResponse errorResponse=response.as(CreateUserErrorResponse.class);
        return errorResponse;
    }

    public GetAllUserResponse getAllUser(){
        Response response=getAllUsers();
        GetAllUserResponse allUserResponse=response.as(GetAllUserResponse.class);
        return allUserResponse;
    }

    public Response create(CreateUserRequestBody body){
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
