package Capstone.DummyAPI.Users.UpdateUserDetails.UpdateUserResponseBody;

import lombok.Data;

@Data
public class UpdateUserResponseBody{
	private String firstName;
	private String lastName;
	private String gender;
	private String phone;
	private String dateOfBirth;
	private Location location;
	private String id;
	private String updatedDate;
	private String title;
	private String picture;
	private String email;
	private String registerDate;
}