package com.zbmatsu.iam.service;

import com.zbmatsu.iam.entity.Permission;
import com.zbmatsu.iam.repository.IPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Janita on 2017/1/1.
 * 权限相关
 */
@Service("permissionService")
public class PermissionService {

    @Autowired
    private IPermissionRepository permissionRepository;

    public Permission createPermission(Permission permission){

        return permissionRepository.save(permission);
    }

    public Permission deletePermissionById(String id){

        Permission permission = permissionRepository.findOne(id);
        permissionRepository.delete(id);
        return permission;
    }

    public Permission getPermissionById(String id){

        return permissionRepository.findOne(id);
    }
}
