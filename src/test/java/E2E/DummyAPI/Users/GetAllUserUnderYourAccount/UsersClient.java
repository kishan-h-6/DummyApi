package E2E.DummyAPI.Users.GetAllUserUnderYourAccount;
import E2E.DummyAPI.Users.GetAllUserUnderYourAccount.GetAllUsersCreatedByAccount.GetAllUserCreatedByAccountResponse;
import User.getValidAppId;
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
