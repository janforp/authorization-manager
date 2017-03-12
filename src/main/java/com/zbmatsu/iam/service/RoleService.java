package com.zbmatsu.iam.service;

import com.zbmatsu.iam.entity.Role;
import com.zbmatsu.iam.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Janita on 2017/1/1.
 * role
 */
@Service("roleService")
public class RoleService {

    @Autowired
    private IRoleRepository roleRepository;

    public Role createRole(Role role){
        return roleRepository.save(role);
    }

    public Role getRoleById(String id){
        return roleRepository.findOne(id);
    }
}
