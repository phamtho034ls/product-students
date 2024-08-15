package com.example.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.first.dto.reponse.UserDTO;
import com.example.first.dto.repuest.CreateUserRequest;
import com.example.first.entity.UserEntity;
import com.example.first.servie.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService useService;
	@GetMapping("/list")
	public List<UserDTO> getUser()
	{
		return useService.getListUser();
	}
	
	@PostMapping("/create")
	public UserDTO createUser(@RequestBody CreateUserRequest bodyUserRequest)
	{
		UserEntity newUser = new UserEntity();
		newUser.setId(bodyUserRequest.getId());
		newUser.setAddress(bodyUserRequest.getAddress());
		newUser.setEmail(bodyUserRequest.getEmail());
		newUser.setFullName(bodyUserRequest.getFullName());
		newUser.setPassword(bodyUserRequest.getPassword());
		newUser.setPhone(bodyUserRequest.getPhone());
		newUser.setUsername(bodyUserRequest.getUsername());
		return useService.saveUser(newUser);
	}
	@DeleteMapping("/delete/{id}")
	public boolean deleteUser(@PathVariable Long id )
	{
		return useService.deleteUser(id);
	}
	@GetMapping("/detail/{id}")
	public UserDTO getUSerDetail(@PathVariable Long id)
	{
		return useService.getUserDetail(id);
	}
}
