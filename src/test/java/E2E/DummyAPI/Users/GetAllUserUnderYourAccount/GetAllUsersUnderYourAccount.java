package E2E.DummyAPI.Users.GetAllUserUnderYourAccount;

import E2E.DummyAPI.Users.Responses.GetAllUsersCreatedByAccount.GetAllUserCreatedByAccountResponse;
import E2E.DummyAPI.Users.UsersClient;
import org.hamcrest.Matchers;
import org.testng.Assert;
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
       GetAllUserCreatedByAccountResponse response= usersClient.getAllUserCreatedByAccount();
        Assert.assertNotNull(response);

    }
}
