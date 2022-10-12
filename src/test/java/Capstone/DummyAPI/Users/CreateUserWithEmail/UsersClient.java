package Capstone.DummyAPI.Users.CreateUserWithEmail;
import Capstone.DummyAPI.Users.CreateUserWithEmail.CreateUserErrorResponse.CreateUserErrorResponse;
import Capstone.DummyAPI.Users.CreateUserWithEmail.CreateUserResponse.CreateUserResponse;
import Capstone.DummyAPI.Users.CreateUserWithEmail.UserRequestBody.CreateUserRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class UsersClient {
    public CreateUserErrorResponse createUserExpectingError(CreateUserRequestBody body){
        Response response = create(body);
        CreateUserErrorResponse errorResponse = response.as(CreateUserErrorResponse.class);
        return errorResponse;
    }
    public CreateUserResponse createUser(CreateUserRequestBody body){
        Response response = create(body);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        return createUserResponse;
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
