package E2E.DummyAPI.Posts.CreateNewPost;

import E2E.DummyAPI.Posts.CreateNewPost.PostRequestBody.CreatePostRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostsClient {
    public Response createPost(CreatePostRequestBody body){
        Response response = given()
                                .accept(ContentType.JSON)
                                .contentType(ContentType.JSON)
                                .header("app-id", "633c1299e9593a1f5e8b8758")
                                .body(body)
                            .when()
                                .post("https://dummyapi.io/data/v1/post/create");
                            response.then().log().body();
                            return response;
    }
}
