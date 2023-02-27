package com.doanwww.shop.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class OrderDTO {
	private List<OrderItemDTO> itemDTOs;

	public List<OrderItemDTO> getItemDTOs() {
		return itemDTOs;
	}

	public void setItemDTOs(List<OrderItemDTO> itemDTOs) {
		this.itemDTOs = itemDTOs;
	}
	
}