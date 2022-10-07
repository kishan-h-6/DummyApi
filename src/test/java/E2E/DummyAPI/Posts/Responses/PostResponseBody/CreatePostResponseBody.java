package E2E.DummyAPI.Posts.Responses.PostResponseBody;

import java.util.List;
import lombok.Data;

@Data
public class CreatePostResponseBody{
	private Owner owner;
	private String image;
	private String link;
	private String publishDate;
	private String id;
	private String text;
	private String updatedDate;
	private int likes;
	private List<String> tags;
}