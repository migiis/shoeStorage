package com.example.ShoeStorag.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Type {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long typeid;
	private String typename;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
	private List<Shoe> shoes;
	
	public Type() {
		
	}
	
	public Type(String typename) {
		super();
		this.typename = typename;
	}

	public long getTypeid() {
		return typeid;
	}

	public void setTypeid(long typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public List<Shoe> getShoes() {
		return shoes;
	}

	public void setShoes(List<Shoe> shoes) {
		this.shoes = shoes;
	}

	@Override
	public String toString() {
		return "Type [typeid=" + typeid + ", typename=" + typename + ", shoes=" + shoes + "]";
	}
}

