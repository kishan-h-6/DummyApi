package E2E.DummyAPI.Posts.PostRequestBody;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreatePostRequestBody {
	private String owner;
	private String image;
	private String text;
	private int likes;
	private List<String> tags;
}