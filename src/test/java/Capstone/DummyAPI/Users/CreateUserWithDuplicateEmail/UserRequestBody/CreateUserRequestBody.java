package Capstone.DummyAPI.Users.CreateUserWithDuplicateEmail.UserRequestBody;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserRequestBody {
    private String firstName;
    private String lastName;
    private String email;
}
