package com.business.entity;


public class Products {
	private int productID;
	private String product_name;
	private double income_price;
	//用对象来存id和name
	private Providers providers;
	private int quantity;
	private double sales_price;
	//用对象来存id和name
	private Categorys categoryID;
	private String income_time;
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Products(String product_name, double income_price, Providers providers, int quantity, double sales_price,
			Categorys categoryID, String income_time) {
		super();
		this.product_name = product_name;
		this.income_price = income_price;
		this.providers = providers;
		this.quantity = quantity;
		this.sales_price = sales_price;
		this.categoryID = categoryID;
		this.income_time = income_time;
	}



	public Products(int productID, String product_name, double income_price, Providers providers, int quantity,
			double sales_price, Categorys categoryID, String income_time) {
		super();
		this.productID = productID;
		this.product_name = product_name;
		this.income_price = income_price;
		this.providers = providers;
		this.quantity = quantity;
		this.sales_price = sales_price;
		this.categoryID = categoryID;
		this.income_time = income_time;
	}



	public int getProductID() {
		return productID;
	}



	public void setProductID(int productID) {
		this.productID = productID;
	}



	public String getProduct_name() {
		return product_name;
	}



	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}



	public double getIncome_price() {
		return income_price;
	}



	public void setIncome_price(double income_price) {
		this.income_price = income_price;
	}



	public Providers getProviders() {
		return providers;
	}



	public void setProviders(Providers providers) {
		this.providers = providers;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public double getSales_price() {
		return sales_price;
	}



	public void setSales_price(double sales_price) {
		this.sales_price = sales_price;
	}



	public Categorys getCategoryID() {
		return categoryID;
	}



	public void setCategoryID(Categorys categoryID) {
		this.categoryID = categoryID;
	}



	public String getIncome_time() {
		return income_time;
	}



	public void setIncome_time(String income_time) {
		this.income_time = income_time;
	}



	@Override
	public String toString() {
		return "Products [productID=" + productID + ", product_name=" + product_name + ", income_price=" + income_price
				+ ", providers=" + providers + ", quantity=" + quantity + ", sales_price=" + sales_price
				+ ", categoryID=" + categoryID + ", income_time=" + income_time + "]";
	}



	
	
	
	

	
	
}
