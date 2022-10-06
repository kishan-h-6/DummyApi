package E2E.DummyAPI.Users.CreateUserWithValidEmail;

import E2E.DummyAPI.Users.UserRequestBody.CreateUserRequestBody;
import E2E.DummyAPI.Users.UsersClient;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

public class CreateUserWithValidEmail {
    private UsersClient usersClient;
    //Arrange
    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }

    @Test(groups = {"api"})
    public void createNewUser(){
        String firstName="kishan";
        String lastName="rao";
        String email=String.format(UUID.randomUUID()+"@gmail.com");

        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .firstName(firstName).lastName(lastName).email(email).build();
        usersClient.createUser(requestBody)
                .then()
                .log().body()
                .statusCode(200);
    }
}
