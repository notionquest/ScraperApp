package com.sainsburys.scraperapp.domain;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Sampath
 *
 */
public class ProductItem {

	private String title;
	private Integer sizeInBytes;
	private BigDecimal unitPrice;
	private String description;

	public ProductItem(String title, Integer sizeInBytes, BigDecimal unitPrice, String description) {
		super();
		this.title = title;
		this.sizeInBytes = sizeInBytes;
		this.unitPrice = unitPrice;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("size")
	public String getSizeInBytes() {
		DecimalFormat dec = new DecimalFormat("0.00");
		return dec.format(sizeInBytes/1024.0).concat("kb");
	}

	public void setSizeInBytes(Integer sizeInBytes) {
		this.sizeInBytes = sizeInBytes;
	}

	@JsonProperty("unit_price")
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProductItem [title=" + title + ", sizeInBytes=" + sizeInBytes + ", unitPrice=" + unitPrice
				+ ", description=" + description + "]";
	}
}
