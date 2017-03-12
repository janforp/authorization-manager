package com.zbmatsu.iam.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 相当于配置文件
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages={"com.zbmatsu.iam.entity"})    //entity package
@EnableJpaRepositories(basePackages = {"com.zbmatsu.iam.repository"})   //jpa
@EnableTransactionManagement    //default transaction
public class JpaConfiguration {

}
