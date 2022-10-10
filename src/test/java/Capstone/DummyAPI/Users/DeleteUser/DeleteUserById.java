package Capstone.DummyAPI.Users.DeleteUser;

import Capstone.DummyAPI.Users.DeleteUser.DeleteUserResponse.DeleteUserResponseBody;
import Capstone.DummyAPI.Users.GetAllUsers.GetAllUserResponse.GetAllUserResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteUserById {
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){usersClient = new UsersClient();} // 1.Arrange
    @Test(groups = {"api"})
    public void deleteUserById(){
        Response allUsers = usersClient.getAllUsers();
        GetAllUserResponse getUserResponse = allUsers.as(GetAllUserResponse.class);
        String userId = getUserResponse.getData().get(0).getId();
        // 2.Act
        Response response = usersClient.deleteUserById(userId);
        DeleteUserResponseBody deleteResponse = response.as(DeleteUserResponseBody.class);
        // 3.Assert
        Assert.assertEquals(deleteResponse.getId(),userId);
    }
}
