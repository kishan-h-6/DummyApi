package Capstone.DummyAPI.Users.UpdateUserDetails;

import Capstone.DummyAPI.Users.UpdateUserDetails.UpdateUserRequestBody.UpdateUserRequestBody;
import Capstone.getValidAppId;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class UsersClient {

    public Response update(UpdateUserRequestBody body){
        return given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("app-id", "633c1299e9593a1f5e8b8758")
                    .body(body)
                .log().body()
                .when()
                     .put("https://dummyapi.io/data/v1/user/60d0fe4f5311236168a10a02");
    }
}
