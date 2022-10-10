package E2E.DummyAPI.Posts.GetAllPosts;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetAllPosts {
    private PostsClient postsClient;
    @BeforeClass
    public void beforeClass(){
        postsClient = new PostsClient();
    } // 1.Arrange
    @Test(groups = {"api"})
    public void getAllPosts(){
                // 2.Act
                 Response response= postsClient.getAllPosts();
                 // 3.Assert
                 Assert.assertNotNull(response);

    }
}
