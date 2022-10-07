package E2E.DummyAPI.Users.Responses.CreateUserResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserResponse{
	private String firstName;
	private String lastName;
	private String id;
	private String updatedDate;
	private String email;
	private String registerDate;

	public String getFirstName(){
		return firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public String getId(){
		return id;
	}

	public String getUpdatedDate(){
		return updatedDate;
	}

	public String getEmail(){
		return email;
	}

	public String getRegisterDate(){
		return registerDate;
	}
}
