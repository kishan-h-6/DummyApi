package Capstone.DummyAPI.Users.UpdateUserDetails.UpdateUserRequestBody;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateUserRequestBody{
	private String firstName;
	private String lastName;
}