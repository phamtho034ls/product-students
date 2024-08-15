package com.example.first.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.first.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
