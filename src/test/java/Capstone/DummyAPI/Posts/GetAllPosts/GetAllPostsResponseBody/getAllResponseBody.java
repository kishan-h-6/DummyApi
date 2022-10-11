package Capstone.DummyAPI.Posts.GetAllPosts.GetAllPostsResponseBody;

import lombok.Data;

import java.util.List;

@Data
public class getAllResponseBody{
	private int total;
	private List<DataItem> data;
	private int limit;
	private int page;
}