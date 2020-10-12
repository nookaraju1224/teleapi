package teleapi.util;

import teleapi.bean.DataWrapper;
import teleapi.bean.ErrorObject;
import teleapi.bean.Product;
import teleapi.bean.ProductResponse;
import teleapi.bean.SearchParam;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;


public class ProductUtil
{

	public static DataWrapper findProducts(String fileName, Map<String, String> searchParams) throws Exception
	{
		ArrayList<Product> products = getProductsFromCSV(fileName);
		SearchParam searchParam = setSearchParams(searchParams);
		return filterProducts(products, searchParam);
	}

	public static ArrayList<Product> getProductsFromCSV(String fileName) throws Exception
	{
		FileInputStream fis = null;
		ArrayList<Product> products = new ArrayList<Product>();
		try
		{

			fis = new FileInputStream(new File(fileName));
			CSVReader reader = new CSVReader(new InputStreamReader(fis));
			String[] nextLine;
			reader.readNext();

			while ((nextLine = reader.readNext()) != null)
			{

				String[] properties = nextLine[1].split(":");
				Map propMap = new HashMap();
				propMap.put(properties[0], properties[1]);
				Product newProduct = new Product(nextLine[0], propMap,
						new BigDecimal(nextLine[2]), nextLine[3]);
				products.add(newProduct);
			}

		}
		catch (FileNotFoundException ex)
		{
			Logger.getLogger(ProductUtil.class.getName()).log(Level.SEVERE, null, ex);
			throw new Exception("Technical issue: please check with support team");
		}
		catch (IOException ex)
		{
			Logger.getLogger(ProductUtil.class.getName()).log(Level.SEVERE, null, ex);
			throw new Exception("Technical issue: please check with support team");
		}
		finally
		{
			try
			{
				if (fis != null)
				{
					fis.close();
				}
			}
			catch (IOException ex)
			{
				Logger.getLogger(ProductUtil.class.getName()).log(Level.SEVERE, "Problem while reading product file::", ex);
			}
		}
		return products;
	}



	public static DataWrapper filterProducts(ArrayList<Product> products, SearchParam searchParam) throws Exception
	{
		ArrayList<Product> filteredProducts = new ArrayList<>();
		try
		{
			if (searchParam != null)
			{
				filteredProducts = (ArrayList<Product>) products.stream()
						.filter(Product -> searchParam.getType() == null || searchParam.getType()
								.equalsIgnoreCase(Product.getProductType()))
						.filter(Product -> searchParam.getMinPrice() == null || searchParam.getMinPrice()
								.compareTo(Product.getPrice()) <= 0)
						.filter(Product -> searchParam.getMaxPrice() == null || searchParam.getMaxPrice()
								.compareTo(Product.getPrice()) >= 0)
						.filter(Product -> searchParam.getCity() == null || Product.getStoreAddress()
								.contains(searchParam.getCity()))
						.filter(Product -> searchParam.getColorProperty() == null || searchParam.getColorProperty()
								.equalsIgnoreCase(Product.getProductProperty().get("color").toString()))
						.filter(Product -> searchParam.getGBLimitMinProperty() == null || searchParam.getGBLimitMinProperty()
								< Double.parseDouble(Product.getProductProperty().get("gb_limit").toString()))
						.filter(Product -> searchParam.getGBLimitMaxProperty() == null || searchParam.getGBLimitMaxProperty()
								> Double.parseDouble(Product.getProductProperty().get("gb_limit").toString()))
						.filter(Product -> searchParam.getGBLmit() == null || searchParam.getGBLmit()
								== Double.parseDouble(Product.getProductProperty().get("gb_limit").toString()))
						.collect(Collectors.toList());

			}
			else
			{
				filteredProducts = products;
			}
		}
		catch (Exception e)
		{
			Logger.getLogger(ProductUtil.class.getName()).log(Level.SEVERE, "Invalid parameters passed or invalid combination::", e);
			throw new Exception("Invalid parameters passed or invalid combination:: " + e);
		}

		return generateProductResponse(filteredProducts);
	}

	public static BigDecimal convertToBigDecimal(String price) throws Exception
	{
		BigDecimal val;
		try
		{
			if (price == null)
			{
				return null;

			}
			else
			{
				val = new BigDecimal(price);
			}

		}
		catch (Exception e)
		{
			Logger.getLogger(ProductUtil.class.getName()).log(Level.SEVERE, "Invalid price format ::", e);
			throw new Exception("Invalid price format :: " + e);
		}
		return val;
	}

	public static Double convertToDouble(String GBLmit) throws Exception
	{
		Double val;
		try
		{
			if (GBLmit == null)
				return null;
			else
				val = Double.parseDouble(GBLmit);
		}
		catch (Exception e)
		{
			Logger.getLogger(ProductUtil.class.getName()).log(Level.SEVERE, "Invalid price format :: ", e);
			throw new Exception("Invalid price format :: " + e);
		}
		return val;
	}

	public static SearchParam setSearchParams(Map<String, String> searchParams) throws Exception
	{
		SearchParam searchPram;
		try
		{
			searchPram = new SearchParam(searchParams.get("type"),
					convertToBigDecimal(searchParams.get("min_price")),
					convertToBigDecimal(searchParams.get("max_price")),
					searchParams.get("city"),
					searchParams.get("property.color"),
					convertToDouble(searchParams.get("property.gb_limit_min")),
					convertToDouble(searchParams.get("property.gb_limit_max")),
					convertToDouble(searchParams.get("property.gb_limit"))
			);
		}
		catch (Exception e)
		{
			Logger.getLogger(ProductUtil.class.getName()).log(Level.SEVERE, "Invalid paramters given, please recheck :", e);
			throw new Exception("Invalid parameters given, please recheck" + e);
		}
		return searchPram;
	}

	private static DataWrapper generateProductResponse(ArrayList<Product> filteredProducts)
	{
		ArrayList<ProductResponse> productResList = new ArrayList<>();
		for (Product prod : filteredProducts)
		{
			Map<String, Object> properties = prod.getProductProperty();
			Map.Entry entry = properties.entrySet().iterator().next();
			ProductResponse prodRes = new ProductResponse(prod.getProductType(),
					entry.getKey() + ":" + entry.getValue(),
					prod.getPrice(), prod.getStoreAddress());
			productResList.add(prodRes);
		}
		return new DataWrapper(productResList);
	}

	public static ErrorObject generateErrorObject(Exception e)
	{
		return new ErrorObject(e.getMessage(), e.getCause().getMessage());
	}
}
