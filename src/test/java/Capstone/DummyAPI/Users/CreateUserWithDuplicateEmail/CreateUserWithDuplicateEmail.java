package Capstone.DummyAPI.Users.CreateUserWithDuplicateEmail;
import Capstone.DummyAPI.Users.CreateUserWithDuplicateEmail.CreateUserErrorResponse.CreateUserErrorResponse;
import Capstone.DummyAPI.Users.CreateUserWithDuplicateEmail.UserRequestBody.CreateUserRequestBody;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class CreateUserWithDuplicateEmail {
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }   // 1.Arrange
    @Test(groups = {"api"})
    public void createNewUserWithError(){
                // 2.Act
                CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                                                    .firstName("kishan")
                                                    .lastName("rao")
                                                    .email("k344@gmail.com").build();
                CreateUserErrorResponse errorResponse = usersClient.createUserExpectingError(requestBody);
                // 3.Assert
                Assert.assertEquals(errorResponse.getData().getEmail(),"Email already used");
    }
}