package E2E.DummyAPI.Users.GetAllUsers;

import E2E.DummyAPI.Users.UsersClient;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

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
        usersClient.getAllUsers()
                .then()
                //Assert
                .log().body()
                .statusCode(200)
                .body("data", Matchers.notNullValue());
    }
}
