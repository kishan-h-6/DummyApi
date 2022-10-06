package E2E.DummyAPI.Posts.GetAllPosts.GetAllPostsResponseBody;

import java.util.List;
import lombok.Data;

@Data
public class DataItem{
	private Owner owner;
	private String image;
	private String publishDate;
	private String id;
	private String text;
	private int likes;
	private List<String> tags;
	private String updatedDate;
}