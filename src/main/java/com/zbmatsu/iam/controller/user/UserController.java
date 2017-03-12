package com.zbmatsu.iam.controller.user;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.alibaba.fastjson.JSONArray;
import com.zbmatsu.iam.entity.Role;
import com.zbmatsu.iam.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.zbmatsu.iam.entity.User;
import com.zbmatsu.iam.enums.IamStatus;
import com.zbmatsu.iam.exception.NotFoundException;
import com.zbmatsu.iam.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/user",produces = "application/json;charset=utf-8")
public class UserController {

	@Autowired
	protected UserService userService;
	@Autowired
	private RoleService roleService;

	@ApiOperation(value="创建用户", notes="根据User对象创建用户")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody User user) throws UnsupportedEncodingException {
		
		UUID uuid  =  UUID.randomUUID();
		user.setId(uuid.toString());
		user.setStatus(IamStatus.NORMAL.toString());
		LocalDateTime current = LocalDateTime.now();
		user.setCreationTime(current);
		user.setModificationTime(current);
		user.setLastUpdateUserId("");
		// TODO: 2017/1/2:应该判断选择的roles是否真实存在,为空的情况

		String roles = user.getRoles();
		if (roles != null && roles.length() > 0){
			List<String> roleIds = JSONArray.parseArray(roles,String.class);
			for (String roleId :roleIds){
				Role role = roleService.getRoleById(roleId);
				if (role == null){
					throw new NotFoundException("role is not found");
				}
			}
		}

		return userService.createUser(user);
	}
	
	@ApiOperation(value="根据ID获取用户信息", notes="根据ID获取用户信息")
	@GetMapping("/{id}")
	public User getUserById(@PathVariable String id){
		
		User user = userService.getUserById(id);
		
		if(user == null){
			throw new NotFoundException("User is not found");
		}
		if (user.getStatus().equals(IamStatus.DELETE.toString())){
			throw new NotFoundException("User is not found");
		}
		return user;
	}

	@ApiOperation(value = "修改用户信息",notes = "修改用户信息")
	@PutMapping("/{id}")
	public User updateUser(@PathVariable String id,@RequestBody User user){
		User oldUser = userService.getUserById(id);
		if (oldUser == null){
			throw new NotFoundException("user is not found");
		}
		user.setCreationTime(oldUser.getCreationTime());
		LocalDateTime current = LocalDateTime.now();
		user.setModificationTime(current);
		user.setLastUpdateUserId("");
		user.setStatus(oldUser.getStatus());
		user.setId(id);
		userService.createUser(user);
		// TODO: 2017/1/2:应该判断选择的roles是否真实存在

		return user;
	}

	@ApiOperation(value = "删除用户",notes = "删除用户")
	@DeleteMapping("/{id}")
	public User removeUser(@PathVariable String id){

		User oldUser = userService.getUserById(id);
		oldUser.setStatus(IamStatus.DELETE.toString());
		oldUser.setModificationTime(LocalDateTime.now());
		oldUser.setLastUpdateUserId("");
		userService.createUser(oldUser);

		return oldUser;
	}
}
