package teleapi.bean;

import java.util.ArrayList;


public class DataWrapper
{
	ArrayList<ProductResponse> data;

	public DataWrapper(ArrayList<ProductResponse> data)
	{
		this.data = data;
	}

	public ArrayList<ProductResponse> getData()
	{
		return data;
	}
}
