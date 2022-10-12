package Capstone.DummyAPI.Users.UpdateUserDetails;
import Capstone.DummyAPI.Posts.GetAllPosts.GetAllPostsResponseBody.getAllResponseBody;
import Capstone.DummyAPI.Users.UpdateUserDetails.UpdateUserRequestBody.UpdateUserRequestBody;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class UpdateUserDetails {
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }   // 1.Arrange
    @Test(groups = {"api"})
    public void UpdateUser(){

                UpdateUserRequestBody requestBody = UpdateUserRequestBody.builder()
                                                    .firstName("kishan")
                                                    .lastName("rao")
                                                    .build();
                Response response = usersClient.update(requestBody);
                // 3.Assert
                Assert.assertNotNull(response);
    }
}
