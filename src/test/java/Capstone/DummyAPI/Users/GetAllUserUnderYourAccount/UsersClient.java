package Capstone.DummyAPI.Users.GetAllUserUnderYourAccount;
import Capstone.DummyAPI.Users.GetAllUserUnderYourAccount.GetAllUsersCreatedByAccount.GetAllUserCreatedByAccountResponse;
import Capstone.getValidAppId;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class UsersClient {
    public GetAllUserCreatedByAccountResponse getAllUserCreatedByAccount(){
        Response response = getAllUserUnderYourAccount();
        GetAllUserCreatedByAccountResponse allUserResponse=response.as(GetAllUserCreatedByAccountResponse.class);
        return allUserResponse;
    }

    public Response getAllUserUnderYourAccount(){
        return given()
                .header("app-id", getValidAppId.ValidAppId)
                .when()
                .get("https://dummyapi.io/data/v1/user?created=1");
    }
}
