package E2E.DummyAPI.Posts.DeletePostByValidId;
import E2E.DummyAPI.Posts.GetAllPosts.GetAllPostsResponseBody.getAllResponseBody;

import E2E.DummyAPI.Posts.PostsClient;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeletePostById {
    private PostsClient postsClient;
    //Arrange
    @BeforeClass
    public void beforeClass(){
        postsClient = new PostsClient();
    }
    @Test(groups = {"api"})
    public void deletePostById(){
            Response response= postsClient.getAllPosts();
             getAllResponseBody getAll=response.as(getAllResponseBody.class);
            String postId= getAll.getData().get(0).getId();
                //Act
                postsClient.deletePostById(postId)

                .then()
                //Assert
                .log().body()
                .statusCode(200)
                        .body("id",Matchers.equalTo(postId));
    }

}
