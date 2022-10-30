package com.company.model;

public class Product {

	
	private Integer id;
	private String name;
	private String description;
	private Long price;
	
	
	
	public Product(Integer id, String name, String description, Long price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public Product() {}
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public Long getPrice() {
		return price;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	
	
}
