package com.springboot.api.dto;

public class VendorDto {
	private Long id;
	private String name;
	private String city;
	private String username;
	public VendorDto(Long id, String name, String city, String username) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.username = username;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "VendorDto [id=" + id + ", name=" + name + ", city=" + city + ", username=" + username + "]";
	}
	
	
}
