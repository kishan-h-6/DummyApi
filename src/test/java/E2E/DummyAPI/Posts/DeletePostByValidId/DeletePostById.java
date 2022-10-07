package E2E.DummyAPI.Posts.DeletePostByValidId;
import E2E.DummyAPI.Posts.DeletePostResponse.DeletePostResponseBody;
import E2E.DummyAPI.Posts.GetAllPosts.GetAllPostsResponseBody.getAllResponseBody;

import E2E.DummyAPI.Posts.PostsClient;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeletePostById {
    private PostsClient postsClient;

    @BeforeClass
    public void beforeClass(){
        postsClient = new PostsClient();
    }
    @Test(groups = {"api"})
    public void deletePostById(){
                //Arrange
                 Response response= postsClient.getAllPosts();
                 getAllResponseBody getAll=response.as(getAllResponseBody.class);
                 String postId= getAll.getData().get(0).getId();
                //Act
        Response response1 = postsClient.deletePostById(postId);
        DeletePostResponseBody deletePostBody= response1.as(DeletePostResponseBody.class);
        Assert.assertEquals(deletePostBody.getId(),postId);
        //Assert

    }

}
