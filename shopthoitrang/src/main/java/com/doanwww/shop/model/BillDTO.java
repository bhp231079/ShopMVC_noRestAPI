package com.doanwww.shop.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillDTO {
	private int id;
	private UserDTO person;
	private Date buyDate;
	private float priceTotal;
	private Integer discountPercent;
}
