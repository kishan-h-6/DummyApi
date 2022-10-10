package E2E.DummyAPI.Posts.GetPostById.GetPostByIdResponse;

import java.util.List;
import lombok.Data;

@Data
public class GetPostByIdResponseBody{
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