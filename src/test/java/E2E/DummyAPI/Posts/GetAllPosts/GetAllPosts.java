package E2E.DummyAPI.Posts.GetAllPosts;

import E2E.DummyAPI.Posts.PostsClient;
import org.hamcrest.Matchers;
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
                 postsClient.getAllPosts()
                .then()
                //Assert
                .log().body()
                .statusCode(200)
                .body("data", Matchers.notNullValue());
    }
}
