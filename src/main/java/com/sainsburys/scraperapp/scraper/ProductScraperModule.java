package com.sainsburys.scraperapp.scraper;

import com.google.inject.AbstractModule;

/**
 * Add the dependencies for the product scraper module
 * 
 * @author Sampath
 *
 */

public class ProductScraperModule extends AbstractModule {
	@Override
	protected void configure() {

		bind(ProductScraper.class);

		bind(ProductDetailsScraper.class);
	}
}
