package E2E.DummyAPI.Users.DeleteUser;

import E2E.DummyAPI.Users.Responses.DeleteUserResponse.DeleteUserResponseBody;
import E2E.DummyAPI.Users.Responses.UserResponseBody.GetUserResponse;
import E2E.DummyAPI.Users.UsersClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteUserById {
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){usersClient = new UsersClient();} // 1.Arrange
    @Test(groups = {"api"})
    public void deleteUserById(){
        Response allUsers = usersClient.getAllUsers();
        GetUserResponse getUserResponse = allUsers.as(GetUserResponse.class);
        String userId= getUserResponse.getData().get(0).getId();
        // 2.Act
        Response response=usersClient.deleteUserById(userId);
        DeleteUserResponseBody deleteResponse=response.as(DeleteUserResponseBody.class);
        // 3.Assert
        Assert.assertEquals(deleteResponse.getId(),userId);
    }
}
