package Capstone.DummyAPI.Users.UpdateUserDetails.UpdateUserResponseBody;

import lombok.Data;

@Data
public class Location{
	private String country;
	private String city;
	private String street;
	private String timezone;
	private String state;
}