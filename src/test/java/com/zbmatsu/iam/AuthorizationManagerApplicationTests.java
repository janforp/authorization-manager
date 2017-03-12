package com.zbmatsu.iam;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @RunWith(SpringRunner.class) tells JUnit to run using Spring’s testing support.
 * SpringRunner is the new name for SpringJUnit4ClassRunner,
 * it’s just a bit easier on the eye.
 *
 * @SpringBootTest is saying “bootstrap with Spring Boot’s support”
 * (e.g. load application.properties and give me all the Spring Boot goodness)
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorizationManagerApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testLamda(){
		String [] persons = {"zhangsan","lisi","wangwu"};
		List<String> plays = Arrays.asList(persons);

		plays.forEach((play) -> System.out.println(play+";***"));
	}
}
