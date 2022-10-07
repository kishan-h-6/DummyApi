package E2E.DummyAPI.Users.GetAllUserResponse;

import java.util.List;

public class GetAllUserResponse{
	private int total;
	private List<DataItem> data;
	private int limit;
	private int page;

	public int getTotal(){
		return total;
	}

	public List<DataItem> getData(){
		return data;
	}

	public int getLimit(){
		return limit;
	}

	public int getPage(){
		return page;
	}
}