package E2E.DummyAPI.Posts.DeletePostByValidId;

import E2E.DummyAPI.Posts.PostsClient;
import E2E.getValidPostId;
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
                //Act
                postsClient.deletePostById()
                .then()
                //Assert
                .log().body()
                .statusCode(200)
                .body("image",Matchers.notNullValue())
                        .body("id",Matchers.equalTo(getValidPostId.ValidPostId));
    }

}
