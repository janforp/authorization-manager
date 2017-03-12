package com.zbmatsu.iam.repository;

import com.zbmatsu.iam.entity.Permission;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by Janita on 2017/1/1.
 */
@Repository("permissionRepository")
public interface IPermissionRepository extends PagingAndSortingRepository<Permission,Serializable> {

}
