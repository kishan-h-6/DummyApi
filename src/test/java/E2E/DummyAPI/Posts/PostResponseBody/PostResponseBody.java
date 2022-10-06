package E2E.DummyAPI.Posts.PostResponseBody;

import java.util.List;
import lombok.Data;
import lombok.Getter;

@Getter
public class PostResponseBody{
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