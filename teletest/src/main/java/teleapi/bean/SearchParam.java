package teleapi.bean;

import java.math.BigDecimal;


public class SearchParam
{
	private String type;
	private BigDecimal minPrice;
	private BigDecimal maxPrice;
	private String city;
	private String colorProperty;
	private Double GBLimitMinProperty;
	private Double GBLimitMaxProperty;
	private Double GBLmit;

	public SearchParam(String type, BigDecimal minPrice, BigDecimal maxPrice, String city, String colorProperty,
			Double GBLimitMinProperty, Double GBLimitMaxProperty,Double GBLmit)
	{
		this.type = type;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.city = city;
		this.colorProperty = colorProperty;
		this.GBLimitMinProperty = GBLimitMinProperty;
		this.GBLimitMaxProperty = GBLimitMaxProperty;
		this.GBLmit=GBLmit;
	}

	public String getType()
	{
		return type;
	}

	public BigDecimal getMinPrice()
	{
		return minPrice;
	}

	public BigDecimal getMaxPrice()
	{
		return maxPrice;
	}

	public String getCity()
	{
		return city;
	}

	public String getColorProperty()
	{
		return colorProperty;
	}

	public Double getGBLimitMinProperty()
	{
		return GBLimitMinProperty;
	}

	public Double getGBLimitMaxProperty()
	{
		return GBLimitMaxProperty;
	}

	public Double getGBLmit()
	{
		return GBLmit;
	}
}
