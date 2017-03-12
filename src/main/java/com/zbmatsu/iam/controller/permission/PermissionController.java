package com.zbmatsu.iam.controller.permission;

import com.zbmatsu.iam.entity.Permission;
import com.zbmatsu.iam.entity.Resource;
import com.zbmatsu.iam.entity.Role;
import com.zbmatsu.iam.exception.NotFoundException;
import com.zbmatsu.iam.service.PermissionService;
import com.zbmatsu.iam.service.ResourceService;
import com.zbmatsu.iam.service.RoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by Janita on 2017/1/1.
 */
@RestController
@RequestMapping(value = "/permission", produces = "application/json;charset=utf-8")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "创建权限",notes = "创建权限")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Permission createPermission(@RequestBody Permission permission){

        permission.setId(UUID.randomUUID().toString());

        String resourceId = permission.getResourceId();
        if (resourceId == null || resourceId.length() == 0){
            throw  new NotFoundException("resource is not found");
        }
        Resource resource = resourceService.getResourceById(resourceId);
        if (resource == null){
            throw  new NotFoundException("resource is not found");
        }

        String  roleId = permission.getRoleId();
        if (roleId == null || roleId.length() == 0){
            throw  new NotFoundException("role is not found");
        }
        Role role = roleService.getRoleById(roleId);
        if (role == null){
            throw  new NotFoundException("role is not found");
        }
        return permissionService.createPermission(permission);
    }

    @ApiOperation(value = "根据id删除权限",notes = "根据id删除权限")
    @DeleteMapping("/{id}")
    public Permission removePermissionById(@PathVariable String id){
        return permissionService.deletePermissionById(id);
    }

    @ApiOperation(value = "修改权限",notes = "修改权限")
    @PutMapping("/{id}")
    public Permission updatePermission(@PathVariable String id , @RequestBody Permission permission){
        Permission oldPermission = permissionService.getPermissionById(id);
        if (oldPermission == null){
            throw  new NotFoundException("permission not found");
        }

        String resourceId = permission.getResourceId();
        if (resourceId == null || resourceId.length() == 0){
            throw  new NotFoundException("resource is not found");
        }
        Resource resource = resourceService.getResourceById(resourceId);
        if (resource == null){
            throw  new NotFoundException("resource is not found");
        }

        String  roleId = permission.getRoleId();
        if (roleId == null || roleId.length() == 0){
            throw  new NotFoundException("role is not found");
        }
        Role role = roleService.getRoleById(roleId);
        if (role == null){
            throw  new NotFoundException("role is not found");
        }
        permission.setId(id);

        return permissionService.createPermission(permission);
    }

    @ApiOperation(value = "根据id查询权限",notes = "根据id查询权限")
    @GetMapping("/{id}")
    public Permission getPermissionById(@PathVariable String id){

        Permission permission = permissionService.getPermissionById(id);
        if (permission == null){
            throw new NotFoundException("permission is not found");
        }
        return permission;
    }
}
