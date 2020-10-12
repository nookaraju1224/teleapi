import teleapi.bean.DataWrapper;
import teleapi.bean.Product;
import teleapi.bean.SearchParam;
import teleapi.util.ProductUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class ProductutiltestClasses
{
	@Test
	public void testFilterProducts1() throws  Exception
	{
		Map searchParams=new HashMap();

		searchParams.put("","" );

		ArrayList<Product> products = new ArrayList<>();
		Map prop1=new HashMap();
		prop1.put("color",120 );
		Product p1=new Product("Phone",prop1,new BigDecimal(10000),"Stockholm");
		Map prop2=new HashMap();
		prop2.put("gb_limit",120 );
		Product p2=new Product("Subscription",prop2,new BigDecimal(20000),"Stockholm");
		Map prop3=new HashMap();
		prop3.put("color",12 );
		Product p3=new Product("Phone",prop3,new BigDecimal(30000),"Stockholm");
		Map prop4=new HashMap();
		prop4.put("gb_limit",120 );
		Product p4=new Product("Subscription",prop4,new BigDecimal(40000),"Stockholm");

		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);

		SearchParam searchParam = ProductUtil.setSearchParams(searchParams);
		DataWrapper wrapper =  ProductUtil.filterProducts(products, searchParam);
		assertThat(wrapper.getData().size())
				.isEqualTo(4);



	}
	@Test
	public void testFilterProducts2() throws  Exception
	{
		Map searchParams=new HashMap();

		searchParams.put("type","subscription" );
		searchParams.put("min_price","21000" );
		searchParams.put("city","Stockholm" );
		ArrayList<Product> products = new ArrayList<>();
		Map prop1=new HashMap();
		prop1.put("color",120 );
		Product p1=new Product("Phone",prop1,new BigDecimal(10000),"Stockholm");
		Map prop2=new HashMap();
		prop2.put("gb_limit",120 );
		Product p2=new Product("Subscription",prop2,new BigDecimal(20000),"Stockholm");
		Map prop3=new HashMap();
		prop3.put("color",12 );
		Product p3=new Product("Phone",prop3,new BigDecimal(30000),"Stockholm");
		Map prop4=new HashMap();
		prop4.put("gb_limit",120 );
		Product p4=new Product("Subscription",prop4,new BigDecimal(40000),"Stockholm");

		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);

		SearchParam searchParam = ProductUtil.setSearchParams(searchParams);
		DataWrapper wrapper=  ProductUtil.filterProducts(products, searchParam);
		assertThat(wrapper.getData().size())
				.isEqualTo(1);



	}

	@Test
	public void testFilterProducts3() throws  Exception
	{
		Map searchParams=new HashMap();

		searchParams.put("type","phone" );
		searchParams.put("min_price","10000" );
		searchParams.put("max_price","25000" );
		/*searchParams.put("city","Stockholm" );
		searchParams.put("property.color","red" );
		searchParams.put("property.gb_limit","1200" );*/
		ArrayList<Product> products = new ArrayList<>();
		Map prop1=new HashMap();
		prop1.put("color","red" );
		Product p1=new Product("Phone",prop1,new BigDecimal(10000),"Stockholm");
		Map prop2=new HashMap();
		prop2.put("gb_limit",2400 );
		Product p2=new Product("Subscription",prop2,new BigDecimal(20000),"Stockholm");
		Map prop3=new HashMap();
		prop3.put("color","green" );
		Product p3=new Product("Phone",prop3,new BigDecimal(30000),"Stockholm");
		Map prop4=new HashMap();
		prop4.put("gb_limit",1200 );
		Product p4=new Product("Subscription",prop4,new BigDecimal(40000),"Stockholm");

		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);

		SearchParam searchParam = ProductUtil.setSearchParams(searchParams);
		DataWrapper wrapper =  ProductUtil.filterProducts(products, searchParam);
		assertThat(wrapper.getData().size())
				.isEqualTo(1);



	}

	@Test
	public void testFilterProducts4() throws  Exception
	{
		Map searchParams=new HashMap();

		searchParams.put("type","phone" );
		searchParams.put("min_price","10000" );
		searchParams.put("max_price","25000" );
		searchParams.put("city","Stockholm" );
		searchParams.put("property.color","green" );
		searchParams.put("property.gb_limit","1200" );
		ArrayList<Product> products = new ArrayList<>();
		Map prop1=new HashMap();
		prop1.put("color","red" );
		Product p1=new Product("Phone",prop1,new BigDecimal(10000),"Stockholm");
		Map prop2=new HashMap();
		prop2.put("gb_limit",2400 );
		Product p2=new Product("Subscription",prop2,new BigDecimal(20000),"Stockholm");
		Map prop3=new HashMap();
		prop3.put("color","green" );
		Product p3=new Product("Phone",prop3,new BigDecimal(30000),"Stockholm");
		Map prop4=new HashMap();
		prop4.put("gb_limit",1200 );
		Product p4=new Product("Subscription",prop4,new BigDecimal(40000),"Stockholm");

		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);

		SearchParam searchParam = ProductUtil.setSearchParams(searchParams);
		DataWrapper wrapper =  ProductUtil.filterProducts(products, searchParam);
		assertThat(wrapper.getData().size())
				.isEqualTo(0);



	}
	@Test
	public void testFilterProducts5() throws  Exception
	{
		Map searchParams=new HashMap();

		searchParams.put("type","subscription" );
		searchParams.put("max_price","1000" );
		searchParams.put("city","Stockholm" );

		ArrayList<Product> products = new ArrayList<>();
		Map prop1=new HashMap();
		prop1.put("color","red" );
		Product p1=new Product("Phone",prop1,new BigDecimal(10000),"Stockholm");
		Map prop2=new HashMap();
		prop2.put("gb_limit",2400 );
		Product p2=new Product("Subscription",prop2,new BigDecimal(20000),"Stockholm");
		Map prop3=new HashMap();
		prop3.put("color","green" );
		Product p3=new Product("Phone",prop3,new BigDecimal(30000),"Stockholm");
		Map prop4=new HashMap();
		prop4.put("gb_limit",1200 );
		Product p4=new Product("Subscription",prop4,new BigDecimal(40000),"Stockholm");

		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);

		SearchParam searchParam = ProductUtil.setSearchParams(searchParams);
		DataWrapper wrapper =  ProductUtil.filterProducts(products, searchParam);
		assertThat(wrapper.getData().size())
				.isEqualTo(0);



	}
}
