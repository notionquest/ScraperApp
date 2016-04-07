package com.sainsburys.scraperapp.scraper;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sainsburys.scraperapp.constant.IScraperConstant;
import com.sainsburys.scraperapp.exception.ScraperException;

public class ProductScraperTest {

	private ProductScraper productScraper;

	@Before
	public void setup() {
		productScraper = new ProductScraper();
	}

	@Test
	public void getProductListUrlTest() throws ScraperException {
		List<String> productUrlList = productScraper.getProductListUrl(IScraperConstant.DEFAULT_URL,
				IScraperConstant.PRODUCT_CSS_STRING);
		Assert.assertNotNull(productUrlList);
		Assert.assertEquals(7, productUrlList.size());

	}
	
	@Test(expected = IllegalStateException.class)
	public void getProductListUrlCssQueryIsNull() throws ScraperException {
		List<String> productUrlList = productScraper.getProductListUrl(IScraperConstant.DEFAULT_URL, null);
		Assert.assertNull(productUrlList);

	}

	@Test(expected = IllegalStateException.class)
	public void getProductListUrlCssQueryIsEmpty() throws ScraperException {
		List<String> productUrlList = productScraper.getProductListUrl(IScraperConstant.DEFAULT_URL, " ");
		Assert.assertNull(productUrlList);

	}

	@Test(expected = IllegalStateException.class)
	public void getProductListUrlIsEmpty() throws ScraperException {
		List<String> productUrlList = productScraper.getProductListUrl("", IScraperConstant.PRODUCT_CSS_STRING);
		Assert.assertNull(productUrlList);

	}

	@Test(expected = IllegalStateException.class)
	public void getProductListUrlIsNull() throws ScraperException {
		List<String> productUrlList = productScraper.getProductListUrl(null, IScraperConstant.PRODUCT_CSS_STRING);
		Assert.assertNull(productUrlList);

	}

	@Test
	public void getProductListUrlWikiTest() throws ScraperException {
		List<String> productUrlList = productScraper.getProductListUrl("https://en.wikipedia.org/wiki/JUnit",
				IScraperConstant.PRODUCT_CSS_STRING);
		Assert.assertNotNull(productUrlList);
		Assert.assertEquals(0, productUrlList.size());

	}

}
