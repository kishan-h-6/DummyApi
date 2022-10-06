package E2E.DummyAPI.Users.DeleteUser;

import E2E.DummyAPI.Users.UserResponseBody.GetUserResponse;
import E2E.DummyAPI.Users.UsersClient;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteUserById {
    private UsersClient usersClient;
    //Arrange

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test(groups = {"api"})
    public void deleteUserById(){

        //Arrange
        Response allUsers = usersClient.getAllUsers();
        GetUserResponse getUserResponse = allUsers.as(GetUserResponse.class);

        String userId= getUserResponse.getData().get(0).getId();
                //Act
                usersClient.deleteUserById(userId)
                .then()
                //Assert
                .log().body()
                .statusCode(200)
                        .body("id",Matchers.equalTo(userId));

    }

}
