package E2E.DummyAPI.Users.GetAllUsers;
import E2E.DummyAPI.Users.GetAllUsers.GetAllUserResponse.GetAllUserResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class GetAllUsers {
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){usersClient = new UsersClient();}  // 1.Arrange
    @Test(groups = "api")
    public void getAllUsers(){
        // 2.Act
        GetAllUserResponse response = usersClient.getAllUser();
        // 3.Assert
        Assert.assertNotNull(response);
    }
}
