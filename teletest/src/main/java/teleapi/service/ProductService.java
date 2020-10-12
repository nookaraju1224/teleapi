package teleapi.service;


import teleapi.bean.DataWrapper;
import teleapi.util.ProductUtil;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class ProductService implements IProductService
{


	@Value("${products.path}")
	private  String fileName;


	@Override
	public DataWrapper findAll(Map<String, String> searchParams) throws Exception
	{
		return ProductUtil.findProducts(fileName, searchParams);
	}
}