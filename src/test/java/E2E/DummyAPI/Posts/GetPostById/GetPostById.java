package E2E.DummyAPI.Posts.GetPostById;
import E2E.DummyAPI.Posts.GetAllPosts.GetAllPostsResponseBody.getAllResponseBody;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetPostById {
    private PostsClient postsClient;
    @BeforeClass
    public void beforeClass(){
        postsClient = new PostsClient();
    } // 1.Arrange
    @Test(groups = "api")
    public void getPostById(){
             // 2.Act
             Response idResponse = postsClient.getAllPosts();
             getAllResponseBody getAll = idResponse.as(getAllResponseBody.class);
             String postId= getAll.getData().get(0).getId();

             Response response= postsClient.getPostById(postId);
             // 3.Assert
             Assert.assertNotNull(response);

    }
}
