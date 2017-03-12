package com.zbmatsu.iam.repository;

import com.zbmatsu.iam.entity.Resource;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by janita on 2017/1/1.
 */
@Repository("resourceRepository")
public interface IResourceRepository extends PagingAndSortingRepository<Resource,Serializable> {

}
