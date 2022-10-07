package E2E.DummyAPI.Users.CreateUserWithDuplicateEmail;
import E2E.DummyAPI.Users.Responses.CreateUserErrorResponse.CreateUserErrorResponse;
import E2E.DummyAPI.Users.Responses.UserRequestBody.CreateUserRequestBody;
import E2E.DummyAPI.Users.UsersClient;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class CreateUserWithDuplicateEmail {
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test(groups = {"api"})
    public void createNewUserWithError(){

        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .firstName("kishan").lastName("rao").email("k344@gmail.com").build();
        CreateUserErrorResponse errorResponse=usersClient.createUserExpectingError(requestBody);
        Assert.assertEquals(errorResponse.getData().getEmail(),"Email already used");
    }
}
