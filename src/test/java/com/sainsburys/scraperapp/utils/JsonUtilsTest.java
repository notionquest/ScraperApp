package com.sainsburys.scraperapp.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sainsburys.scraperapp.domain.ProductItem;
import com.sainsburys.scraperapp.domain.ProductsResult;
import com.sainsburys.scraperapp.exception.ScraperException;

public class JsonUtilsTest {
	
	private ProductsResult productsResult;
	
	@Before
	public void setup() {
		
		productsResult = new ProductsResult();
		List<ProductItem> productItemList = new ArrayList<ProductItem> ();
		ProductItem productItem = new ProductItem("Sainsbury's Apricot Ripe & Ready x5", 300, new BigDecimal(3.0), "Apricots");
		productItemList.add(productItem);
		
	}
	
	@Test
	public void convertToJsonString () throws ScraperException {
		Assert.assertNotNull(JsonUtils.convertToJsonString(productsResult));
	}
	
	@Test
	public void convertToJsonNullString () throws ScraperException {
		Assert.assertNotNull(JsonUtils.convertToJsonString(null));
		Assert.assertEquals("null", JsonUtils.convertToJsonString(null));
	}

}
