package com.doanwww.shop.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;


/**
 * The persistent class for the billproduct database table.
 * 
 */
@Entity
@NamedQuery(name="Billproduct.findAll", query="SELECT b FROM Billproduct b")
@AllArgsConstructor
public class Billproduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BillproductPK id;

	private int quantity;

	private float unitPrice;

	//bi-directional many-to-one association to Bill
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("billid")
	@JoinColumn(name="Billid")
	private Bill bill;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("prid")
	@JoinColumn(name="Prid")
	private Product product;

	public Billproduct() {
	}

	public BillproductPK getId() {
		return this.id;
	}

	public void setId(BillproductPK id) {
		this.id = id;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Bill getBill() {
		return this.bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}