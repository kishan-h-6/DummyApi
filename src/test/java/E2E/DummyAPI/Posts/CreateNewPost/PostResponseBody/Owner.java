package E2E.DummyAPI.Posts.CreateNewPost.PostResponseBody;

import lombok.Data;

@Data
public class Owner{
	private String firstName;
	private String lastName;
	private String id;
	private String title;
	private String picture;
}