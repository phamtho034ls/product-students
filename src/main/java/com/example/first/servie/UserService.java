package com.example.first.servie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.first.dto.reponse.UserDTO;
import com.example.first.entity.UserEntity;
import com.example.first.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public List<UserDTO> getListUser() {
		List<UserEntity> result = userRepository.findAll();
		List<UserDTO> listUser = new ArrayList<UserDTO>();
		for (UserEntity userEntity : result) {
			UserDTO dto = new UserDTO();
			dto.setId(userEntity.getId());
			dto.setAddress(userEntity.getAddress());
			dto.setEmail(userEntity.getEmail());
			dto.setFullName(userEntity.getFullName());
			dto.setPassword(userEntity.getPassword());
			dto.setPhone(userEntity.getPhone());
			dto.setUsername(userEntity.getUsername());
			listUser.add(dto);
		}
		return listUser;
	}

	public UserDTO saveUser(UserEntity newUser) {
		UserEntity user = userRepository.save(newUser);
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setAddress(user.getAddress());
		dto.setEmail(user.getEmail());
		dto.setFullName(user.getFullName());
		dto.setPassword(user.getPassword());
		dto.setPhone(user.getPhone());
		dto.setUsername(user.getUsername());
		return dto;
	}

	public boolean deleteUser(Long id) {
		boolean isExist = userRepository.existsById(id);
		if (isExist) {
			userRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public UserDTO getUserDetail(Long id) {
			UserEntity user = userRepository.findById(id).get();
			UserDTO dto = new UserDTO(user.getId(),user.getUsername(),user.getFullName(),
					user.getEmail(),user.getPhone(),user.getAddress());
			return dto;
	}
}
