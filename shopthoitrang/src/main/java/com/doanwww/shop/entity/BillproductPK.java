package com.doanwww.shop.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;

/**
 * The primary key class for the billproduct database table.
 * 
 */
@Embeddable
@AllArgsConstructor
public class BillproductPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int prid;

	private int billid;

	public BillproductPK() {
	}
	public int getPrid() {
		return this.prid;
	}
	public void setPrid(int prid) {
		this.prid = prid;
	}
	public int getBillid() {
		return this.billid;
	}
	public void setBillid(int billid) {
		this.billid = billid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BillproductPK)) {
			return false;
		}
		BillproductPK castOther = (BillproductPK)other;
		return 
			(this.prid == castOther.prid)
			&& (this.billid == castOther.billid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.prid;
		hash = hash * prime + this.billid;
		
		return hash;
	}
}