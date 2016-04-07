package com.sainsburys.scraperapp.scraper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Preconditions;
import com.sainsburys.scraperapp.constant.IScraperConstant;
import com.sainsburys.scraperapp.domain.PageDocument;
import com.sainsburys.scraperapp.domain.ProductItem;
import com.sainsburys.scraperapp.exception.ScraperException;

/**
 * Get the products details from the product web pages
 * 
 * @author Sampath
 *
 */
public class ProductDetailsScraper extends BaseScraper {

	/**
	 * Produce a {@link List<ProductItem>} instance from a URL list
	 * 
	 * @param urlList
	 *            URL list of the web pages
	 * @return List<ProductItem> instance
	 */
	public List<ProductItem> getProductItemDetails(List<String> urlList) throws ScraperException {

		List<ProductItem> result = null;
		Preconditions.checkState(urlList != null, "Url list cannot be null");
		Preconditions.checkState(!urlList.isEmpty(), "Url list cannot be empty");

		for (String url : urlList) {
			PageDocument pageDocument = convertToPageDocument(url);

			if (result == null) {
				result = new ArrayList<>();
			}
			String title = getElementValueAsString(pageDocument.getDocument(), IScraperConstant.TITLE_CSS_STRING);
			Integer sizeInBytes = pageDocument.getContentLength();
			BigDecimal unitPrice = getElementValueAsBigDecimal(pageDocument.getDocument(),
					IScraperConstant.PRICE_CSS_STRING);
			String description = getElementValueAsString(pageDocument.getDocument(),
					IScraperConstant.DESCRIPTION_CSS_STRING);

			ProductItem productItem = new ProductItem(title, sizeInBytes, unitPrice, description);
			result.add(productItem);
		}
		return result;

	}

}
