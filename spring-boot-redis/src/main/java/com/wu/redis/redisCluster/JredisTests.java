package com.wu.redis.redisCluster;

import com.wu.redis.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JredisTests {

	@Autowired
	private RedisTemplate<String, User> redisTemplate1;

	@Test
	public void test1() throws Exception {
		// 保存对象
		User user = new User("1111", 20);
		redisTemplate1.opsForValue().set(user.getUsername(), user);
		Assert.assertEquals(20, redisTemplate1.opsForValue().get("超人").getAge().longValue());
	}

}