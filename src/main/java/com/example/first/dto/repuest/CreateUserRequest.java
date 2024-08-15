package com.example.first.dto.repuest;

public class CreateUserRequest {
	private Long id;
	private String username;
	private String fullName;
	private String password;
	private String email;
	private String phone;
	private String address;

	public CreateUserRequest() {

	}

	public CreateUserRequest( String username, String fullName, String password, String email, String phone,
			String address) {
		super();
		
		this.username = username;
		this.fullName = fullName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

}
