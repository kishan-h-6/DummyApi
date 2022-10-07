package E2E.DummyAPI.Posts;
import E2E.DummyAPI.Posts.Responses.PostRequestBody.CreatePostRequestBody;
import User.getValidAppId;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class PostsClient {
    public Response getAllPosts(){
        return given()
                .header("app-id", getValidAppId.ValidAppId)
                .when()
                .get("https://dummyapi.io/data/v1/post");
    }

    public Response getPostById(String postId){
        return given()
                .header("app-id", getValidAppId.ValidAppId)
                .when()
                .get("https://dummyapi.io/data/v1/post/"+postId);
    }
    public Response deletePostById(String postId){
        Response response = given()
                .header("app-id", getValidAppId.ValidAppId)
                .when()
                .delete("https://dummyapi.io/data/v1/post/" + postId);
        response
                .then()
                .log().body();

        return response;

    }

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
