package E2E.DummyAPI.Posts.PostBody;

import java.util.List;
import lombok.Getter;

@Getter
public class GetPostResponse{
	private int total;
	private List<DataItem> data;
	private int limit;
	private int page;
}