package com.sainsburys.scraperapp.scraper;

import java.util.List;

import com.google.inject.Inject;
import com.sainsburys.scraperapp.constant.IScraperConstant;
import com.sainsburys.scraperapp.domain.ProductItem;
import com.sainsburys.scraperapp.exception.ScraperException;

/**
 * Get the products details from the product web page
 * 
 * @author Sampath
 *
 */
public class ProductScraperService implements IScraperService {

	private final ProductScraper productScraper;
	private final ProductDetailsScraper productDetailsScraper;

	@Inject
	ProductScraperService(ProductScraper productScraper, ProductDetailsScraper productDetailsScraper) {
		this.productScraper = productScraper;
		this.productDetailsScraper = productDetailsScraper;
	}

	/**
	 * Produce a {@link List<ProductItem>} instance from a URL
	 * 
	 * @param url
	 *            URL of a web pages
	 * @return List<ProductItem> instance
	 */
	public List<ProductItem> scrapePage(String url) throws ScraperException {
		List<String> productUrlList = productScraper.getProductListUrl(url, IScraperConstant.PRODUCT_CSS_STRING);

		return productDetailsScraper.getProductItemDetails(productUrlList);
	}

}
