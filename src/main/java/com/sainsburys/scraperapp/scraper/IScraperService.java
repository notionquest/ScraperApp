package com.sainsburys.scraperapp.scraper;

import java.util.List;

import com.sainsburys.scraperapp.domain.ProductItem;
import com.sainsburys.scraperapp.exception.ScraperException;

/**
 * Get the required details from a web page
 * 
 * @author Sampath
 *
 */
public interface IScraperService {
	
	public List<ProductItem> scrapePage(String url) throws ScraperException;

}
