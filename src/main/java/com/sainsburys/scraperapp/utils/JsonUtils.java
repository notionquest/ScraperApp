package com.sainsburys.scraperapp.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.sainsburys.scraperapp.domain.ProductsResult;
import com.sainsburys.scraperapp.exception.ScraperException;

/**
 * Convert the object into JSON
 * 
 * @author Sampath
 *
 */
public class JsonUtils {

	/**
	 * Produce a {@link String} instance for an object
	 * 
	 * @param productsResult
	 *            Products result object with all required data
	 * @return String instance
	 */
	public static String convertToJsonString(ProductsResult productsResult) throws ScraperException {

		ObjectMapper mapper = new ObjectMapper();
		mapper.setNodeFactory(JsonNodeFactory.withExactBigDecimals(true));
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			return mapper.writeValueAsString(productsResult);
		} catch (JsonProcessingException e) {
			throw new ScraperException("Unable to convert products result to JSON", e);
		}

	}

}
