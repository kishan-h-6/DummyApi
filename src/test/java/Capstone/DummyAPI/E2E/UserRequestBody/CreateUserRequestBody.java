package Capstone.DummyAPI.E2E.UserRequestBody;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserRequestBody {
    private String firstName;
    private String lastName;
    private String email;
}
