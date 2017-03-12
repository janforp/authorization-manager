package com.zbmatsu.iam.controller.resource;

import com.zbmatsu.iam.entity.Resource;
import com.zbmatsu.iam.enums.IamStatus;
import com.zbmatsu.iam.exception.NotFoundException;
import com.zbmatsu.iam.service.ResourceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by Janita on 2017/1/1.
 */
@RestController
@RequestMapping(value = "/resource", produces = "application/json;charset=utf-8")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @ApiOperation(value = "创建资源",notes = "根据resource创建资源")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Resource createResource(@RequestBody Resource resource){

        UUID resourceId = UUID.randomUUID();
        resource.setId(resourceId.toString());
        resource.setStatus(IamStatus.NORMAL.toString());

        return resourceService.createResource(resource);
    }

    @ApiOperation(value = "根据资源id获取资源",notes = "根据资源id获取资源")
    @GetMapping("/{id}")
    public Resource getResourceById(@PathVariable String id){

        Resource resource = resourceService.getResourceById(id);
        if (resource == null){
            throw new NotFoundException("resource is not found");
        }
        if (resource.getStatus().equals(IamStatus.DELETE.toString())){
            throw new NotFoundException("resource is not found");
        }
        return resourceService.getResourceById(id);
    }

    /**
     * 并不是真正的删除,
     * 只是status的状态
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id删除某个资源",notes = "根据id删除某个资源")
    @DeleteMapping("/{id}")
    public Resource removeResourceById(@PathVariable String id){

        Resource oldResource = resourceService.getResourceById(id);
        oldResource.setStatus(IamStatus.DELETE.toString());

        return resourceService.createResource(oldResource);
    }

    @ApiOperation(value = "修改资源",notes = "修改资源")
    @PutMapping("/{id}")
    public Resource updateResource(@PathVariable String id, @RequestBody Resource resource){

        Resource oldResource = resourceService.getResourceById(id);
        if (oldResource == null){
            throw new NotFoundException("resource is not found");
        }
        resource.setId(oldResource.getId());
        resource.setStatus(oldResource.getStatus());

        return resourceService.createResource(resource);
    }
}