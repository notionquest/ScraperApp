package com.sainsburys.scraperapp.scraper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.containsString;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sainsburys.scraperapp.constant.IScraperConstant;
import com.sainsburys.scraperapp.domain.ProductItem;
import com.sainsburys.scraperapp.exception.ScraperException;

public class ProductDetailsScraperTest {

	private ProductScraper productScraper;
	private ProductDetailsScraper productDetailsScraper;
	private List<String> urlList;

	@Before
	public void setup() {
		productScraper = new ProductScraper();
		productDetailsScraper = new ProductDetailsScraper();
		urlList = new ArrayList<String>();
	}

	@Test
	public void getProductItemDetailsForApricotUrl() throws ScraperException {

		urlList.add(
				"http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/sainsburys-apricot-ripe---ready-320g.html");
		List<ProductItem> productItemList = productDetailsScraper.getProductItemDetails(urlList);

		Assert.assertNotNull(productItemList);
		Assert.assertEquals(1, productItemList.size());

		assertThat(productItemList.get(0), instanceOf(ProductItem.class));
		assertThat(productItemList.get(0).getTitle(), containsString("Sainsbury's Apricot Ripe & Ready x5"));
		assertThat(productItemList.get(0).getSizeInBytes().toString(), containsString("38.27kb"));
		assertThat(productItemList.get(0).getUnitPrice().toString(), containsString("3.50"));
		assertThat(productItemList.get(0).getDescription(), containsString("Apricots"));

	}
	
	@Test
	public void getProductItemDetailsForAllProducts() throws ScraperException {

		urlList = productScraper.getProductListUrl(IScraperConstant.DEFAULT_URL, IScraperConstant.PRODUCT_CSS_STRING);
		List<ProductItem> productItemList = productDetailsScraper.getProductItemDetails(urlList);

		Assert.assertNotNull(productItemList);
		Assert.assertEquals(7, productItemList.size());

		assertThat(productItemList.get(0), instanceOf(ProductItem.class));
		assertThat(productItemList.get(0).getTitle(), containsString("Sainsbury's Apricot Ripe & Ready x5"));
		assertThat(productItemList.get(0).getSizeInBytes().toString(), containsString("38.27kb"));
		assertThat(productItemList.get(0).getUnitPrice().toString(), containsString("3.50"));
		assertThat(productItemList.get(0).getDescription(), containsString("Apricots"));
		
		assertThat(productItemList.get(1), instanceOf(ProductItem.class));
		assertThat(productItemList.get(1).getTitle(), containsString("Sainsbury's Avocado Ripe & Ready XL Loose 300g"));
		assertThat(productItemList.get(1).getSizeInBytes().toString(), containsString("38.67kb"));
		assertThat(productItemList.get(1).getUnitPrice().toString(), containsString("1.50"));
		assertThat(productItemList.get(1).getDescription(), containsString("Avocados"));
		
		assertThat(productItemList.get(2), instanceOf(ProductItem.class));
		assertThat(productItemList.get(2).getTitle(), containsString("Sainsbury's Avocado, Ripe & Ready x2"));
		assertThat(productItemList.get(2).getSizeInBytes().toString(), containsString("43.44kb"));
		assertThat(productItemList.get(2).getUnitPrice().toString(), containsString("1.80"));
		assertThat(productItemList.get(2).getDescription(), containsString("Avocados"));

		assertThat(productItemList.get(3), instanceOf(ProductItem.class));
		assertThat(productItemList.get(3).getTitle(), containsString("Sainsbury's Avocados, Ripe & Ready x4"));
		assertThat(productItemList.get(3).getSizeInBytes().toString(), containsString("38.68kb"));
		assertThat(productItemList.get(3).getUnitPrice().toString(), containsString("3.20"));
		assertThat(productItemList.get(3).getDescription(), containsString("Avocados"));
		
		assertThat(productItemList.get(4), instanceOf(ProductItem.class));
		assertThat(productItemList.get(4).getTitle(), containsString("Sainsbury's Conference Pears, Ripe & Ready x4 (minimum)"));
		assertThat(productItemList.get(4).getSizeInBytes().toString(), containsString("38.54kb"));
		assertThat(productItemList.get(4).getUnitPrice().toString(), containsString("1.50"));
		assertThat(productItemList.get(4).getDescription(), containsString("Conference"));
		
		assertThat(productItemList.get(5), instanceOf(ProductItem.class));
		assertThat(productItemList.get(5).getTitle(), containsString("Sainsbury's Golden Kiwi x4"));
		assertThat(productItemList.get(5).getSizeInBytes().toString(), containsString("38.56kb"));
		assertThat(productItemList.get(5).getUnitPrice().toString(), containsString("1.80"));
		assertThat(productItemList.get(5).getDescription(), containsString("Gold Kiwi"));
		
		assertThat(productItemList.get(6), instanceOf(ProductItem.class));
		assertThat(productItemList.get(6).getTitle(), containsString("Sainsbury's Kiwi Fruit, Ripe & Ready x4"));
		assertThat(productItemList.get(6).getSizeInBytes().toString(), containsString("38.98kb"));
		assertThat(productItemList.get(6).getUnitPrice().toString(), containsString("1.80"));
		assertThat(productItemList.get(6).getDescription(), containsString("Kiwi"));

	}

	@Test(expected = IllegalStateException.class)
	public void getProductItemDetailsForNull() throws ScraperException {

		productDetailsScraper.getProductItemDetails(null);

	}
	
	@Test(expected = IllegalStateException.class)
	public void getProductItemDetailsForEmpty() throws ScraperException {

		productDetailsScraper.getProductItemDetails(urlList);

	}
	
}
