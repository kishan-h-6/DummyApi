package Capstone.DummyAPI.Users.CreateUserWithDuplicateEmail;
import Capstone.DummyAPI.Users.CreateUserWithDuplicateEmail.CreateUserErrorResponse.CreateUserErrorResponse;
import Capstone.DummyAPI.Users.CreateUserWithDuplicateEmail.UserRequestBody.CreateUserRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class UsersClient {
    public CreateUserErrorResponse createUserExpectingError(CreateUserRequestBody body){
        Response response = create(body);
        CreateUserErrorResponse errorResponse = response.as(CreateUserErrorResponse.class);
        return errorResponse;
    }

    public Response create(CreateUserRequestBody body){
        return given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("app-id", "633c1299e9593a1f5e8b8758")
                    .body(body)
                .when()
                     .post("https://dummyapi.io/data/v1/user/create");
    }
}
