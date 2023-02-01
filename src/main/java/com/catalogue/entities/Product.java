package com.catalogue.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="product_details")
public class Product extends Abstract {
    @Column(name="product_name",nullable=false)
	private String name;
    @Column(name="product_category")
    private String category;
    public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Column(name="Product_type",nullable=false)
	private String productType;
   
    @Column(name="product_price",nullable=false)
	private double baseprice;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public double getBaseprice() {
		return baseprice;
	}
	public void setBaseprice(double baseprice) {
		this.baseprice = baseprice;
	}
    
}
	

