package com.sainsburys.scraperapp.scraper;

import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.sainsburys.scraperapp.domain.PageDocument;
import com.sainsburys.scraperapp.exception.ScraperException;

/**
 * Get the products URLs from a web page
 * 
 * @author Sampath
 *
 */
public class ProductScraper extends BaseScraper {

	/**
	 * Produce a {@link List<String>} instance from a URL and query
	 * 
	 * @param url
	 *            URL of the web page
	 * @param cssQuery
	 *            String to get the product URL data
	 * @return List<String> instance
	 */	
	public List<String> getProductListUrl(String url, String cssQuery) throws ScraperException {

		Preconditions.checkState(url!=null && url.trim().length()!=0, "Url cannot be null or empty");
		Preconditions.checkState(cssQuery!=null && cssQuery.trim().length()!=0, "CSS Query cannot be null or empty");
		List<String> result = Lists.newArrayList();

		PageDocument pageDocument = convertToPageDocument(url);

		Elements elements = pageDocument.getDocument().select(cssQuery);
		
		for (Element element : elements) {
			result.add(element.attr("href"));
		}

		return result;

	}

}
