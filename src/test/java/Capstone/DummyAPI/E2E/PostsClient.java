package Capstone.DummyAPI.E2E;

import Capstone.DummyAPI.Posts.CreateNewPost.PostRequestBody.CreatePostRequestBody;
import Capstone.getValidAppId;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostsClient {

    public Response getPostById(String postId){
        return given()
                .header("app-id", getValidAppId.ValidAppId)
                .when()
                .get("https://dummyapi.io/data/v1/post/"+postId);
    }
    public Response createPost(CreatePostRequestBody body){
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("app-id", getValidAppId.ValidAppId)
                .body(body)
                .when()
                .post("https://dummyapi.io/data/v1/post/create");
        response.then().log().body();
        return response;
    }
    public Response deletePostById(String postId){
        return given()
                .header("app-id", getValidAppId.ValidAppId)
                .when()
                .delete("https://dummyapi.io/data/v1/post/" + postId);
    }
}
