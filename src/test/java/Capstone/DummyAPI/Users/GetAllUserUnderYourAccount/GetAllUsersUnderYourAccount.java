package Capstone.DummyAPI.Users.GetAllUserUnderYourAccount;
import Capstone.DummyAPI.Users.GetAllUserUnderYourAccount.GetAllUsersCreatedByAccount.GetAllUserCreatedByAccountResponse;
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
        GetAllUserCreatedByAccountResponse response = usersClient.getAllUserCreatedByAccount();
        // 3.Assert
        Assert.assertNotNull(response);
    }
}
