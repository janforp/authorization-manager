package com.zbmatsu.iam.controller.role;

import com.zbmatsu.iam.entity.Role;
import com.zbmatsu.iam.enums.IamStatus;
import com.zbmatsu.iam.exception.NotFoundException;
import com.zbmatsu.iam.service.RoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Janita on 2017/1/1.
 */
@RestController
@RequestMapping(value = "/role", produces = "application/json;charset=utf-8")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 所有的创建的正确状态码均为为201,批量创建除外
     * 其他默认为200
     * @param role
     * @return
     */
    @ApiOperation(value = "创建role",notes = "创建role")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Role createRole(@RequestBody Role role){

        role.setId(UUID.randomUUID().toString());
        LocalDateTime current = LocalDateTime.now();
        role.setCreationTime(current);

        return roleService.createRole(role);
    }

    /**
     * just update status = 1
     * 其实并没有物理删除,而是逻辑删除
     * 但是开放的接口要给使用者一种物理删除的感觉
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id删除role",notes = "根据id删除role")
    @DeleteMapping("/{id}")
    public Role removeRole(@PathVariable String id){

        Role role = roleService.getRoleById(id);
        role.setStatus(IamStatus.DELETE.toString());

        return roleService.createRole(role);
    }

    /**
     * 修改的接口标准:url中带上id,
     * @RequestBody Role role中可以不带id,
     * 只带修改的参数即可
     *
     * @param id
     * @param role
     * @return
     */
    @ApiOperation(value = "修改role",notes = "修改role")
    @PutMapping("/{id}")
    public Role updateRole(@PathVariable String id, @RequestBody Role role){
        Role oldRole = roleService.getRoleById(id);
        if (oldRole==null){
            throw new NotFoundException("Role is not found");
        }
        role.setCreationTime(oldRole.getCreationTime());
        role.setStatus(oldRole.getStatus());
        return roleService.createRole(role);
    }

    @ApiOperation(value = "根据id查询role",notes = "根据id查询role")
    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable String id){
    	
    	Role role = roleService.getRoleById(id);
    	
    	if(role == null){
            //此处抛出异常之后会被CustomExceptionHandler类补货,并根据异常类型调用不同的异常处理方法
    		throw new NotFoundException("Role is not found");
    	}
        return role;
    }

}
