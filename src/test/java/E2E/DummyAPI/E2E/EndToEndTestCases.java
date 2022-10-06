package E2E.DummyAPI.E2E;

import E2E.DummyAPI.Posts.PostRequestBody.CreatePostRequestBody;
import E2E.DummyAPI.Posts.PostResponseBody.PostResponseBody;
import E2E.DummyAPI.Posts.PostsClient;
import E2E.DummyAPI.Users.UsersClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class EndToEndTestCases {
    private PostsClient postsClient;
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        postsClient=new PostsClient();
        usersClient=new UsersClient();
    }

    @Test
    public void end2EndTestsCases(){
        String text="kishanSDET";
        String image="http://placeimg.com/640/480";
        List<String> tags= List.of(new String[]{"dog", "animal", "husky"});
        String owner= "633e8d7552b10b51d3b29986";
        CreatePostRequestBody requestBody=CreatePostRequestBody.builder()
                .tags(tags).owner(owner).likes(0).image(image).text(text).build();

        Response response = postsClient.createPost(requestBody);
        PostResponseBody postResponseBody = response.as(PostResponseBody.class);
        Assert.assertNotNull(postResponseBody);
        Assert.assertEquals(response.statusCode(),200);

        Response postResponseById = postsClient.getPostById(postResponseBody.getId());
        PostResponseBody postResponseByIdBody = postResponseById.as(PostResponseBody.class);
        Assert.assertEquals(postResponseById.statusCode(),200);

        Response postDeleteByIdResponse= postsClient.deletePostById(postResponseBody.getId());
        PostResponseBody postDeleteByIdResponseBody=postDeleteByIdResponse.as(PostResponseBody.class);
        Assert.assertEquals(postResponseById.statusCode(),200);
        Assert.assertEquals(postDeleteByIdResponseBody.getId(),postResponseByIdBody.getId());
    }

}
