package com.zbmatsu.iam.repository;

import com.zbmatsu.iam.entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by Janita on 2017/1/1.
 */
@Repository("roleRepository")
public interface IRoleRepository extends PagingAndSortingRepository<Role,Serializable> {
}
