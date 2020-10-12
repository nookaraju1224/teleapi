package teleapi.service;




import teleapi.bean.DataWrapper;
import java.util.Map;


public interface IProductService
{

	public DataWrapper findAll(Map<String,String> searchParams) throws Exception;
}