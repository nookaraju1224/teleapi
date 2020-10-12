package teleapi.bean;

public class ErrorObject
{

	private String errorMessage;
	private String moredetails;

	public ErrorObject( String errorMessage, String moredetails)
	{

		this.errorMessage = errorMessage;
		this.moredetails = moredetails;
	}



	public String getErrorMessage()
	{
		return errorMessage;
	}

	public String getMoredetails()
	{
		return moredetails;
	}
}
