package com.wu.mongdb;

import com.wu.mongdb.domain.User;
import com.wu.mongdb.domain.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Before
	public void setUp() {
		userRepository.deleteAll();
	}

	@Test
	public void test() throws Exception {

		// 创建三个User，并验证User总数
		userRepository.save(new User(1L, "didi", 30));
		userRepository.save(new User(2L, "mama", 40));
		userRepository.save(new User(3L, "kaka", 50));
		Assert.assertEquals(3, userRepository.findAll().size());

		//User user = new User(1L);
		//ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("id");
		//Example<User> example = Example.of(user, matcher);
//
		//// 删除一个User，再验证User总数
		//User u = userRepository.findById(example);
		//userRepository.delete(u);
		//Assert.assertEquals(2, userRepository.findAll().size());

		// 删除一个User，再验证User总数
		User u = userRepository.findByUsername("mama");
		userRepository.delete(u);
		Assert.assertEquals(1, userRepository.findAll().size());

	}

}
