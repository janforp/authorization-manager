package com.zbmatsu.iam.jsonb.dialect;

import java.sql.Types;

import org.hibernate.dialect.PostgreSQL9Dialect;

/**
 * 自定义postgresql方言
 */
public class CustomPostgreSQLDialect extends PostgreSQL9Dialect{

	public CustomPostgreSQLDialect(){
		 super();
		 this.registerColumnType(Types.JAVA_OBJECT, "json");
	}
}
