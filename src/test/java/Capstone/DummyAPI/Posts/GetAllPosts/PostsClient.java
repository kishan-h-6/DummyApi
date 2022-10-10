package Capstone.DummyAPI.Posts.GetAllPosts;

import User.getValidAppId;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostsClient {
    public Response getAllPosts(){
        return given()
                .header("app-id", getValidAppId.ValidAppId)
                .when()
                .get("https://dummyapi.io/data/v1/post");
    }
}
