//package E2E.DummyAPI.E2E;
//
//import E2E.DummyAPI.Posts.CreateNewPost.PostsClient;
//import E2E.DummyAPI.Posts.Responses.PostRequestBody.CreatePostRequestBody;
//import E2E.DummyAPI.Posts.Responses.PostResponseBody.CreatePostResponseBody;
//import E2E.DummyAPI.Users.UsersClient;
//import io.restassured.response.Response;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//public class EndToEndTestCases {
//    private PostsClient postsClient;
//    private UsersClient usersClient;
//
//    @BeforeClass
//    public void beforeClass(){
//        postsClient=new PostsClient();
//        usersClient=new UsersClient();
//    }
//
//    @Test(groups = "api")
//    public void end2EndTestsCases(){
//        String text="kishanSDET";
//        String image="http://placeimg.com/640/480";
//        List<String> tags= List.of(new String[]{"dog", "animal", "husky"});
//        String owner= "60d0fe4f5311236168a109e8";
//        CreatePostRequestBody requestBody=CreatePostRequestBody.builder()
//                .tags(tags).owner(owner).likes(0).image(image).text(text).build();
//
//        Response response = postsClient.createPost(requestBody);
//        CreatePostResponseBody postResponseBody = response.as(CreatePostResponseBody.class);
//        Assert.assertNotNull(postResponseBody);
//        Assert.assertEquals(response.statusCode(),200);
//
//        Response postResponseById = postsClient.getPostById(postResponseBody.getId());
//        CreatePostResponseBody postResponseByIdBody = postResponseById.as(CreatePostResponseBody.class);
//        Assert.assertEquals(postResponseById.statusCode(),200);
//
//        Response postDeleteByIdResponse= postsClient.deletePostById(postResponseBody.getId());
//        CreatePostResponseBody postDeleteByIdResponseBody=postDeleteByIdResponse.as(CreatePostResponseBody.class);
//        Assert.assertEquals(postResponseById.statusCode(),200);
//        Assert.assertEquals(postDeleteByIdResponseBody.getId(),postResponseByIdBody.getId());
//    }
//
//}
