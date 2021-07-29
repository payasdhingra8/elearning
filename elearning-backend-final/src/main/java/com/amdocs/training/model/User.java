package com.amdocs.training.model;

public class User {
	
	private Long id;
	private String username;
	private String phone;
	private String email;
	private String address;
	private String regDate;
	private String password;
	private String photo;	


	public User(Long id, String username, String phone, String email, String address, String regDate, String password,
			String photo) {
		super();
		this.id = id;
		this.username = username;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.regDate = regDate;
		this.password = password;
		this.photo = photo;
	}


	
	
	
	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getUsername() {
		return username;
	}





	public void setUsername(String username) {
		this.username = username;
	}





	public String getPhone() {
		return phone;
	}





	public void setPhone(String phone) {
		this.phone = phone;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getAddress() {
		return address;
	}





	public void setAddress(String address) {
		this.address = address;
	}





	public String getRegDate() {
		return regDate;
	}





	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public String getPhoto() {
		return photo;
	}





	public void setPhoto(String photo) {
		this.photo = photo;
	}





	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", address=" + address + "phone" + phone + "reg date" + regDate + "photo" + photo + "]";
	}


	
}
