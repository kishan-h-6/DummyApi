package E2E.DummyAPI.Users.GetAllUserUnderYourAccount;
import E2E.DummyAPI.Users.Responses.GetAllUsersCreatedByAccount.GetAllUserCreatedByAccountResponse;
import E2E.DummyAPI.Users.UsersClient;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class GetAllUsersUnderYourAccount {
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){usersClient = new UsersClient();} // 1.Arrange
    @Test(groups = {"api"})
    public void getAllUsersUnderYouAccount(){
        // 2.Act
        GetAllUserCreatedByAccountResponse response= usersClient.getAllUserCreatedByAccount();
        // 3.Assert
        Assert.assertNotNull(response);
    }
}
