package com.doanwww.shop.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * The persistent class for the color database table.
 * 
 */
@Entity
@NamedQuery(name="Color.findAll", query="SELECT c FROM Color c")

@AllArgsConstructor
public class Color implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="color")
	private List<Product> products;

	public Color() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}