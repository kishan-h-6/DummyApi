package E2E.DummyAPI.Users.GetAllUsers;

import E2E.DummyAPI.Users.GetAllUserResponse.GetAllUserResponse;
import E2E.DummyAPI.Users.UsersClient;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class GetAllUsers {
    private UsersClient usersClient;
    //Arrange
    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test(groups = {"api"})
    public void getAllUsers(){
        //Act
        GetAllUserResponse response=usersClient.getAllUser();
        Assert.assertNotNull(response);

    }
}
