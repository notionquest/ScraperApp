package com.sainsburys.scraperapp.domain;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Sampath
 *
 */
public class ProductsResult {

	private List<ProductItem> products;
	private BigDecimal total;

	@JsonProperty("results")
	public List<ProductItem> getProducts() {
		return products;
	}

	public void setProducts(List<ProductItem> products) {
		this.products = products;
	}

	@JsonProperty("total")
	public BigDecimal getTotal() {
		if (products != null) {
			for (ProductItem productItem : products) {
				if (total == null) {
					total = new BigDecimal(0.0);

				}
				total = total.add(productItem.getUnitPrice());
			}
		}
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "ProductsList [products=" + products + ", total=" + total + "]";
	}

}
