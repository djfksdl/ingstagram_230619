package com.ingstagram.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingstagram.user.entity.UserEntity;
import com.ingstagram.user.repository.UserRepository;

@Service
public class UserBO {
	@Autowired
	private UserRepository userRepository;
	
	public UserEntity getUsesrEntityById(int userId) {
		return userRepository.findById(userId).orElse(null);
	}
	public UserEntity getUserEntityByLoginId(String loginId) {
		return userRepository.findByLoginId(loginId);
	}
	public Integer addUser(String loginId, String password, String name)
}