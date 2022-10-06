package E2E.DummyAPI.Users.GetAllUserUnderYourAccount;

import E2E.DummyAPI.Users.UsersClient;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetAllUsersUnderYourAccount {
    private UsersClient usersClient;
    //Arrange
    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test(groups = {"api"})
    public void getAllUsersUnderYouAccount(){
        //Act
        usersClient.getAllUserUnderYourAccount()
                .then()
                //Assert
                .log().body()
                .statusCode(200)
                .body("data", Matchers.notNullValue());
    }
}
