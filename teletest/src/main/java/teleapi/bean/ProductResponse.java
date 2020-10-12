package teleapi.bean;

import java.math.BigDecimal;


public class ProductResponse
{
	private String productType;
	private String productProperty;
	private BigDecimal price;
	private String storeAddress;

	public ProductResponse(String productType, String productProperty, BigDecimal price, String storeAddress)
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

	public String getProductProperty()
	{
		return productProperty;
	}


}
