package com.doanwww.shop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillProductDTO {
	private BillPKDTO id;
	private float unitPrice;
	private int quantity;
	private BillDTO bill;
	private ProductDTO product;
	
}
