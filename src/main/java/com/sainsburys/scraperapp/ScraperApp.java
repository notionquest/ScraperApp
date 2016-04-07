package com.sainsburys.scraperapp;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sainsburys.scraperapp.constant.IScraperConstant;
import com.sainsburys.scraperapp.domain.ProductsResult;
import com.sainsburys.scraperapp.exception.ScraperException;
import com.sainsburys.scraperapp.scraper.ProductScraperModule;
import com.sainsburys.scraperapp.scraper.ProductScraperService;
import com.sainsburys.scraperapp.utils.JsonUtils;

/**
 * Scraper app to get the product details from a web page in JSON format
 * 
 * @author Sampath
 *
 */
public class ScraperApp {
	public static void main(String[] args) {

		Injector injector = Guice.createInjector(new ProductScraperModule());

		ProductScraperService productScraperService = injector.getInstance(ProductScraperService.class);
		ProductsResult productResults = new ProductsResult();

		try {
			productResults.setProducts(productScraperService.scrapePage(IScraperConstant.DEFAULT_URL));

			System.out.println(JsonUtils.convertToJsonString(productResults));
		} catch (ScraperException e) {
			e.printStackTrace();
		}
	}
}
