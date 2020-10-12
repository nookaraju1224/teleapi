package teleapi.bean;

import java.math.BigDecimal;
import java.util.Map;


public class Product
{
	private String productType;
	private Map productProperty;
	private BigDecimal price;
	private String storeAddress;

	public Product(String productType, Map productProperty, BigDecimal price, String storeAddress)
	{
		this.productType = productType;
		this.productProperty = productProperty;
		this.price = price;
		this.storeAddress = storeAddress;
	}

	public String getProductType()
	{
		return productType;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	public String getStoreAddress()
	{
		return storeAddress;
	}

	public Map getProductProperty()
	{
		return productProperty;
	}


}
