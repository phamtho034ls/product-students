package com.example.first.dto.repuest;

public class CreateCategoryRequest {
	private  String name;
	private String description;
	private Long id;
	
	public CreateCategoryRequest() {
		
	}
	public CreateCategoryRequest(String name, String description) {
		super();
		this.name = name;
		this.description = description;
		
	}
	public CreateCategoryRequest(String name, String description, Long id) {
		super();
		this.name = name;
		this.description = description;
		this.id =id;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
