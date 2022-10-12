package Capstone.DummyAPI.Users.CreateUserWithEmail.UserRequestBody;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserRequestBody {
    private String firstName;
    private String lastName;
    private String email;
}
