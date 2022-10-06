package E2E.DummyAPI.Posts.GetPostById;

import E2E.DummyAPI.Posts.PostsClient;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetPostById {
    private PostsClient postsClient;
    //Arrange
    @BeforeClass
    public void beforeClass(){
        postsClient = new PostsClient();
    }
    @Test(groups = {"api"})
    public void getPostById(){
                //Act
                postsClient.getPostById()
                .then()
                //Assert
                .log().body()
                .statusCode(200)
                .body("image",Matchers.notNullValue());
    }
}
