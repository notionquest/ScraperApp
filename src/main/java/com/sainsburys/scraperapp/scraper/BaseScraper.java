package com.sainsburys.scraperapp.scraper;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.google.common.base.Preconditions;
import com.sainsburys.scraperapp.domain.PageDocument;
import com.sainsburys.scraperapp.exception.ScraperException;

/**
 * Parse the web page and convert into Document. Extract the data from document
 * based on query string.
 * 
 * @author Sampath
 *
 */
public class BaseScraper {

	/**
	 * Produce a {@link PageDocument} instance from a url
	 * 
	 * @param url
	 *            Url that has to be converted into document
	 * @return PageDocument instance
	 */
	public PageDocument convertToPageDocument(String url) throws ScraperException {

		Preconditions.checkNotNull(url, "Url cannot be null");

		PageDocument pageDocument = null;
		try {
			URLConnection connection = new URL(url).openConnection();
			Document doc = Jsoup.parse(connection.getInputStream(), "UTF-8", "http://baseUrl/");
			pageDocument = new PageDocument(doc, connection.getContentLength());
		} catch (IOException e) {
			throw new ScraperException("Error scraping url : " + url, e);
		}
		return pageDocument;

	}

	/**
	 * Produce a {@link String} instance from a document and cssquery
	 * 
	 * @param document
	 *            Document to get the data for cssQuery string
	 * @param cssQuery
	 *            String to filter the data from document
	 * @return String instance
	 */

	public String getElementValueAsString(Document document, String cssQuery) throws ScraperException {
		Preconditions.checkNotNull(document, "Document cannot be null");

		Elements elements = document.select(cssQuery);
		if (elements.isEmpty()) {
			throw new ScraperException("Unable to get element for '" + cssQuery + "'");
		}
		return elements.get(0).ownText();

	}

	/**
	 * Produce a {@link BigDecimal} instance from a document and cssquery
	 * 
	 * @param document
	 *            Document to get the data for cssQuery string
	 * @param cssQuery
	 *            String to filter the data from document
	 * @return BigDecimal instance
	 */

	public BigDecimal getElementValueAsBigDecimal(Document document, String cssQuery) throws ScraperException {
		Preconditions.checkNotNull(document, "Document cannot be null");

		Elements elements = document.select(cssQuery);
		if (elements.isEmpty()) {
			throw new ScraperException("Unable to get element for '" + cssQuery + "'");
		}
		String price = elements.get(0).ownText();
		price = price.replace("£", "");
		return new BigDecimal(price);

	}

}
