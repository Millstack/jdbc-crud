package com.jsp.Dto;

public class Cafe {
	
	private int id;
	private String name;
	private String type;
	private String category;
	private double price;
	
	public Cafe() {
		super();
	}
	
	public Cafe(int id, String name, String type, String category, double price) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.category = category;
		this.price = price;
	}

	public Cafe(String name, String type, String category, double price) {
		super();
		this.name = name;
		this.type = type;
		this.category = category;
		this.price = price;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cafe [id=" + id + ", name=" + name + ", type=" + type + ", category=" + category + ", price=" + price
				+ "]";
	}
}
