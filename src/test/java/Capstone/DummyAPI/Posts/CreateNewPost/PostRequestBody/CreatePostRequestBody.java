package Capstone.DummyAPI.Posts.CreateNewPost.PostRequestBody;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CreatePostRequestBody {

	private String owner;
	private String image;
	private String text;
	private int likes;
	private List<String> tags;
}