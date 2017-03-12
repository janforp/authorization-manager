package com.zbmatsu.iam.service;

import com.zbmatsu.iam.entity.Resource;
import com.zbmatsu.iam.repository.IResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Janita on 2017/1/1.
 * 资源相关操作
 */
@Service("resourceService")
public class ResourceService {

    @Autowired
    private IResourceRepository resourceRepository;

    public Resource createResource(Resource resource){

        return resourceRepository.save(resource);
    }

    public Resource getResourceById(String id){

        return resourceRepository.findOne(id);
    }
}