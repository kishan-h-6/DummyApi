package Capstone.DummyAPI.Posts.CreateNewPost.PostResponseBody;

import lombok.Data;

import java.util.List;

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