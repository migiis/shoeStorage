package com.example.ShoeStorag.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Shoe {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long shoeid;
	private String brand;
	private String name;
	private String gender;
	private String size;
	private String price;
	
	/*@ManyToOne
	@JoinColumn(name = "id")
	private User user;*/
	
	@ManyToOne
	@JoinColumn(name = "typeid")
	private Type type;
	
	public Shoe() {
		
	}
	
	public Shoe(String brand, String name, String gender, String size, String price, Type type/*, User user*/) {
		super();
		this.brand = brand;
		this.name = name;
		this.gender = gender;
		this.size = size;
		this.price = price;
		this.type = type;
		//this.user = user;
	}

	public long getShoeid() {
		return shoeid;
	}

	public void setShoeid(long shoeid) {
		this.shoeid = shoeid;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	/*public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}*/

	@Override
	public String toString() {
		return "Shoe [brand=" + brand + ", name=" + name + ", gender=" + gender + ", size=" + size + ", price=" + price
				+ "]";
	}
}