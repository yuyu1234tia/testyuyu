package com.ibm.devworks.examples.java.lll;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Print
 *
 */
@Entity

public class Print implements Serializable {

	   
	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String description;
	private String imgsrc;
	private float price;
	private int quan;
	private static final long serialVersionUID = 1L;

	public Print() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getImgsrc() {
		return imgsrc;
	}
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}   
	public int getQuan() {
		return this.quan;
	}

	public void setQuan(int quan) {
		this.quan = quan;
	}
   
}
