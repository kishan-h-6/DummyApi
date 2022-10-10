package Capstone.DummyAPI.Posts.DeletePostByValidId;

import Capstone.getValidAppId;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class PostsClient {

    public Response deletePostById(String postId){
        return given()
                .header("app-id", getValidAppId.ValidAppId)
                .when()
                .delete("https://dummyapi.io/data/v1/post/" + postId);
    }
    public Response getAllPosts(){
        return given()
                .header("app-id", getValidAppId.ValidAppId)
                .when()
                .get("https://dummyapi.io/data/v1/post");
    }
}
