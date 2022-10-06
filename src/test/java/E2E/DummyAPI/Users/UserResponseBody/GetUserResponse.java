package E2E.DummyAPI.Users.UserResponseBody;

import java.util.List;
import lombok.Data;

@Data
public class GetUserResponse{
	private int total;
	private List<DataItem> data;
	private int limit;
	private int page;
}