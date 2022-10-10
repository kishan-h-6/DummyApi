package E2E.DummyAPI.Users.CreateUserWithValidEmail;

import E2E.DummyAPI.Users.Responses.CreateUserResponse.CreateUserResponse;
import E2E.DummyAPI.Users.Responses.UserRequestBody.CreateUserRequestBody;
import E2E.DummyAPI.Users.UsersClient;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.UUID;

public class CreateUserWithValidEmail {
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){usersClient = new UsersClient();}
    @Test(groups = {"api"})
    public void createNewUser(){
        // 1.Arrange
        String firstName = "kishan";
        String lastName = "rao";
        String email = String.format(UUID.randomUUID()+"@gmail.com");
        // 2.Act
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                                            .firstName(firstName)
                                            .lastName(lastName)
                                            .email(email).build();
        CreateUserResponse response = usersClient.createUser(requestBody);
        // 3.Assert
        Assert.assertNotNull(response);
    }
}
