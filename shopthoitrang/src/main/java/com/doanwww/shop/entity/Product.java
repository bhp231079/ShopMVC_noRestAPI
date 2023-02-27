package com.doanwww.shop.entity;
import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */

@Entity
@AllArgsConstructor
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int count;

	private String description;

	private String image;

	private String name;

	
	private float price;

	//bi-directional many-to-one association to Billproduct

	//bi-directional many-to-one association to Category
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="DMid")
	private Category category;

	//bi-directional many-to-one association to Color
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CLid")
	private Color color;ư

	//bi-directional many-to-one association to Gender
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GTid")
	private Gender gender;

	//bi-directional many-to-one association to Size
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="KTid")
	private Size size;

	//bi-directional many-to-one association to Trademark
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="THid")
	private Trademark trademark;

	public Product() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Size getSize() {
		return this.size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Trademark getTrademark() {
		return this.trademark;
	}

	public void setTrademark(Trademark trademark) {
		this.trademark = trademark;
	}

}