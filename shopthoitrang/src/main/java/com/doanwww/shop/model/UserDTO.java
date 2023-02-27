package com.doanwww.shop.model;

import javax.annotation.Generated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	private int id;
	private String name;
	private int age;
	private String role;
	private String username;
	private String password;
	private String address;
	private String gender;
	private String phone;
	private String email;


}