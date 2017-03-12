package com.zbmatsu.iam.repository;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.zbmatsu.iam.entity.User;


/**
 * Created by Janita on 2016/12/31.
 * spring-data packaged hibernate
 *
 * you can also create your sql
 *
 * PagingAndSortingRepository
 *
 * 相当于dao
 */
@Repository("userRepository")
public interface IUserRepository extends PagingAndSortingRepository<User, Serializable>{

}
