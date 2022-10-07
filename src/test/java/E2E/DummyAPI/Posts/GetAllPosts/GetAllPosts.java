package E2E.DummyAPI.Posts.GetAllPosts;

import E2E.DummyAPI.Posts.PostsClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetAllPosts {
    private PostsClient postsClient;
    //Arrange
    @BeforeClass
    public void beforeClass(){
        postsClient = new PostsClient();
    }

    @Test(groups = {"api"})
    public void getAllPosts(){
                //Act
                 Response response= postsClient.getAllPosts();
                 Assert.assertNotNull(response);

    }
}
