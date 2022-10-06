package E2E.DummyAPI.Posts.CreateNewPost;

import E2E.DummyAPI.Posts.PostRequestBody.CreatePostRequestBody;
import E2E.DummyAPI.Posts.PostResponseBody.PostResponseBody;
import E2E.DummyAPI.Posts.PostsClient;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.UUID;

public class CreateNewPost {
    private PostsClient postsClient;
    //Arrange
    @BeforeClass
    public void beforeClass(){
        postsClient = new PostsClient();
    }

    @Test(groups = {"api"})
    public void createNewPost(){
        String text="kishanSDET";
        String image="http://placeimg.com/640/480";
        List<String> tags= List.of(new String[]{"dog", "animal", "husky"});
        String owner= "633e8d7552b10b51d3b29986";
        CreatePostRequestBody requestBody=CreatePostRequestBody.builder()
                .tags(tags).owner(owner).likes(0).image(image).text(text).build();
        postsClient.createPost(requestBody).then().log().body().statusCode(200);
    }
}
