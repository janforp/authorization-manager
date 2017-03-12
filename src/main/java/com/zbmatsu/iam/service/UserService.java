package com.zbmatsu.iam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbmatsu.iam.entity.User;
import com.zbmatsu.iam.repository.IUserRepository;


/**
 * Created by Janita on 2016/12/31.
 * 用户相关操作
 */

@Service("userService")
public class UserService {

	@Autowired
	protected IUserRepository userRepository;
	
	
	public User getUserById(String id) {
		
		return userRepository.findOne(id);
	}
	
	public User createUser(User user){
		
		return userRepository.save(user);
	}
}
