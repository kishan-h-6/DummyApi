package Capstone.DummyAPI.Posts.CreateNewPost;

import Capstone.DummyAPI.Posts.CreateNewPost.PostRequestBody.CreatePostRequestBody;
import Capstone.DummyAPI.Posts.CreateNewPost.PostResponseBody.CreatePostResponseBody;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class CreateNewPost {
    private PostsClient postsClient;
    @BeforeClass
    public void beforeClass(){postsClient = new PostsClient();}
    @Test(groups = "api")
    public void createNewPost(){
        // 1.Arrange
        String text="kishanSDET";
        String image="http://placeimg.com/640/480";
        List<String> tags = List.of(new String[]{"dog", "animal", "husky"});
        String owner= "60d0fe4f5311236168a109f3";
        // 2.Act
        CreatePostRequestBody requestBody = CreatePostRequestBody.builder()
                                            .tags(tags)
                                            .owner(owner)
                                            .likes(0)
                                            .image(image)
                                            .text(text).build();
        Response response = postsClient.createPost(requestBody);
        CreatePostResponseBody postResponseBody = response.as(CreatePostResponseBody.class);
        // 3.Assert
        Assert.assertNotNull(postResponseBody);
    }
}
