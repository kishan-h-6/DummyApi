package E2E.DummyAPI.Posts.DeletePostByValidId;
import E2E.DummyAPI.Posts.Responses.DeletePostResponse.DeletePostResponseBody;
import E2E.DummyAPI.Posts.Responses.GetAllPostsResponseBody.getAllResponseBody;
import E2E.DummyAPI.Posts.PostsClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeletePostById {
    private PostsClient postsClient;
    @BeforeClass // 1.Arrange
    public void beforeClass(){
        postsClient = new PostsClient();
    }
    @Test(groups = {"api"})
    public void deletePostById(){
        // 2.Act
        Response response = postsClient.getAllPosts();
        getAllResponseBody getAll = response.as(getAllResponseBody.class);
        String postId= getAll.getData().get(0).getId();

        Response response1 = postsClient.deletePostById(postId);
        DeletePostResponseBody deletePostBody= response1.as(DeletePostResponseBody.class);
        // 3.Assert
        Assert.assertEquals(deletePostBody.getId(),postId);

    }

}
