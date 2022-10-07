package E2E.DummyAPI.Posts.Responses.GetAllPostsResponseBody;

import java.util.List;
import lombok.Data;

@Data
public class getAllResponseBody{
	private int total;
	private List<DataItem> data;
	private int limit;
	private int page;
}