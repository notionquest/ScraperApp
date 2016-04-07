package com.sainsburys.scraperapp.scraper;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.jsoup.Jsoup;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sainsburys.scraperapp.constant.IScraperConstant;
import com.sainsburys.scraperapp.domain.PageDocument;
import com.sainsburys.scraperapp.exception.ScraperException;

public class BaseScraperTest {

	private BaseScraper baseScraper;

	@Before
	public void setup() {
		baseScraper = new BaseScraper();
	}

	@Test
	public void convertToPageDocumentIsNotNull() throws ScraperException {
		PageDocument pageDocument = baseScraper.convertToPageDocument(IScraperConstant.DEFAULT_URL);
		Assert.assertNotNull(pageDocument);
		Assert.assertNotNull(pageDocument.getContentLength());
		Assert.assertEquals(new Integer(84542), pageDocument.getContentLength());

	}

	@Test
	public void getProductElementOfflineTest() throws ScraperException, IOException {
		String productName = baseScraper.getElementValueAsString(
				Jsoup.parse(getClass().getClassLoader().getResourceAsStream("products.html"), "UTF-8", "http://testurl"),
				IScraperConstant.PRODUCT_CSS_STRING);
		Assert.assertNotNull(productName);
		Assert.assertEquals("Sainsbury's Apricot Ripe & Ready x5", productName);

	}
	
	@Test
	public void getProductElementKiwiOfflineTest() throws ScraperException, IOException {
		String title = baseScraper.getElementValueAsString(
				Jsoup.parse(getClass().getClassLoader().getResourceAsStream("kiwiproduct.html"), "UTF-8", "http://testurl"),
				IScraperConstant.TITLE_CSS_STRING);
		Assert.assertNotNull(title);
		Assert.assertEquals("Sainsbury's Kiwi Fruit, Ripe & Ready x4", title);

	}
	
	@Test
	public void getProductElementKiwiPriceOfflineTest() throws ScraperException, IOException {
		BigDecimal price = baseScraper.getElementValueAsBigDecimal(
				Jsoup.parse(getClass().getClassLoader().getResourceAsStream("kiwiproduct.html"), "UTF-8", "http://testurl"),
				IScraperConstant.PRICE_CSS_STRING);
		Assert.assertNotNull(price);
		MathContext mc = new MathContext(2, RoundingMode.HALF_UP);
		Assert.assertEquals(new BigDecimal(1.80, mc), new BigDecimal(price.doubleValue(), mc));

	}	

	@Test
	public void convertToPageDocumentIsNotNullForWiki() throws ScraperException {
		Assert.assertNotNull(baseScraper.convertToPageDocument("https://en.wikipedia.org/wiki/JUnit"));
	}

	@Test(expected = NullPointerException.class)
	public void convertToPageDocumentIsNull() throws ScraperException {
		baseScraper.convertToPageDocument(null);
	}

	@Test
	public void getElementValueAsStringTitle() throws ScraperException {
		PageDocument pageDocument = baseScraper.convertToPageDocument(
				"http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/sainsburys-apricot-ripe---ready-320g.html");

		Assert.assertEquals("Sainsbury's Apricot Ripe & Ready x5",
				baseScraper.getElementValueAsString(pageDocument.getDocument(), IScraperConstant.TITLE_CSS_STRING));

	}

	@Test
	public void getElementValueAsStringDescription() throws ScraperException {
		PageDocument pageDocument = baseScraper.convertToPageDocument(
				"http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/sainsburys-apricot-ripe---ready-320g.html");

		Assert.assertEquals("Apricots", baseScraper.getElementValueAsString(pageDocument.getDocument(),
				IScraperConstant.DESCRIPTION_CSS_STRING));

	}

	@Test
	public void getElementValueAsBigDecimal() throws ScraperException {
		PageDocument pageDocument = baseScraper.convertToPageDocument(
				"http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/sainsburys-apricot-ripe---ready-320g.html");

		Assert.assertEquals(new BigDecimal("3.50"),
				baseScraper.getElementValueAsBigDecimal(pageDocument.getDocument(), IScraperConstant.PRICE_CSS_STRING));

	}
}
