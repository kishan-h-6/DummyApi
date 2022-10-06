package E2E.DummyAPI.Users.CreateUserWithDuplicateEmail;

import E2E.DummyAPI.Users.UserRequestBody.CreateUserRequestBody;
import E2E.DummyAPI.Users.UsersClient;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CreateUserWithDuplicateEmail {
    private UsersClient usersClient;
    //Arrange
    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }


    @Test(groups = {"api"})
    public void createNewUser(){
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .firstName("kishan").lastName("rao").email("k344@gmail.com").build();
        usersClient.createUser(requestBody)
                .then()
                .log().body()
                .statusCode(400)
                .body("data.email", Matchers.equalTo("Email already used"));
    }
}
