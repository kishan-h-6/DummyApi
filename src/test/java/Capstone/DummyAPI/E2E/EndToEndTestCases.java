package Capstone.DummyAPI.E2E;
import Capstone.DummyAPI.E2E.UserRequestBody.CreateUserRequestBody;
import Capstone.DummyAPI.E2E.CreateUserResponse.CreateUserResponse;
import Capstone.DummyAPI.Posts.CreateNewPost.PostRequestBody.CreatePostRequestBody;
import Capstone.DummyAPI.Posts.CreateNewPost.PostResponseBody.CreatePostResponseBody;
import Capstone.DummyAPI.Users.DeleteUser.DeleteUserResponse.DeleteUserResponseBody;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.UUID;

public class EndToEndTestCases {
    private PostsClient postsClient;
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        postsClient=new PostsClient();
        usersClient=new UsersClient();
    }

    @Test(groups = "api")
    public void end2EndTestsCases(){

        String firstName = "kishan";
        String lastName = "rao";
        String email = String.format(UUID.randomUUID()+"@gmail.com");
        // 2.Act
        CreateUserRequestBody userBody = CreateUserRequestBody.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email).build();
        Response createUserBody = usersClient.create(userBody);
        CreateUserResponse createUserResponseBody=createUserBody.as(CreateUserResponse.class);
        Assert.assertNotNull(createUserResponseBody);

        String text="Random text for the post";
        String image="randomImageLink.com";
        List<String> tags= List.of(new String[]{"dog", "animal", "husky"});
        String owner= createUserResponseBody.getId();
        CreatePostRequestBody requestBody=CreatePostRequestBody.builder()
                .tags(tags).owner(owner).likes(0).image(image).text(text).build();

        Response response = postsClient.createPost(requestBody);
        CreatePostResponseBody postResponseBody = response.as(CreatePostResponseBody.class);
        Assert.assertNotNull(postResponseBody);
        Assert.assertEquals(response.statusCode(),200);

        Response postResponseById = postsClient.getPostById(postResponseBody.getId());
        CreatePostResponseBody postResponseByIdBody = postResponseById.as(CreatePostResponseBody.class);
        Assert.assertEquals(postResponseById.statusCode(),200);

        Response postDeleteByIdResponse= postsClient.deletePostById(postResponseBody.getId());
        CreatePostResponseBody postDeleteByIdResponseBody=postDeleteByIdResponse.as(CreatePostResponseBody.class);
        Assert.assertEquals(postResponseById.statusCode(),200);
        Assert.assertEquals(postDeleteByIdResponseBody.getId(),postResponseByIdBody.getId());

        Response deleteUserResponse = usersClient.deleteUserById(createUserResponseBody.getId());
        DeleteUserResponseBody deleteResponse = deleteUserResponse.as(DeleteUserResponseBody.class);
        Assert.assertNotNull(deleteResponse);
    }

}
