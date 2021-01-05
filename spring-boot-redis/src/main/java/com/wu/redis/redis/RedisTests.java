package com.wu.redis.redis;

import com.wu.redis.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=RedisMain.class)
public class RedisTests {
	/**
	 * 1.两者的关系是StringRedisTemplate继承RedisTemplate。
	 * 2.两者的数据是不共通的；也就是说StringRedisTemplate只能管理StringRedisTemplate里面的数据，RedisTemplate只能管理RedisTemplate中的数据。
	 * 3.SDR默认采用的序列化策略有两种，一种是String的序列化策略，一种是JDK的序列化策略。
	 *
	 * StringRedisTemplate默认采用的是String的序列化策略，保存的key和value都是采用此策略序列化保存的。
	 * RedisTemplate默认采用的是JDK的序列化策略，保存的key和value都是采用此策略序列化保存的。
	 */

	//StringRedisTemplate使用的是 StringRedisSerializer
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	//RedisTemplate使用的是 JdkSerializationRedisSerializer
	@Autowired
	private RedisTemplate redisTemplate;

	//redisTemplate.opsForValue() 操作字符串
	//redisTemplate.opsForHash() 操作hash
	//redisTemplate.opsForList() 操作list
	//redisTemplate.opsForSet() 操作set
	//redisTemplate.opsForZSet() 操作有序set
	@Test
	public void test() throws Exception {
		// 保存字符串
		stringRedisTemplate.opsForValue().set("ccc", "333");
		Assert.assertEquals("333", stringRedisTemplate.opsForValue().get("ccc"));

		// 保存对象
		ValueOperations<String, User> operations = redisTemplate.opsForValue();
		User user = new User("2323", 20);
		operations.set(user.getUsername(), user);

		//hash保存
		redisTemplate.opsForHash().put("user:","2",user);
		/*查看redisTemplate 的Serializer*/
		System.out.println("redisTemplate="+redisTemplate.getKeySerializer());
		System.out.println("redisTemplate="+redisTemplate.getValueSerializer());

		/*查看StringRedisTemplate 的Serializer*/
		System.out.println("stringRedisTemplate="+stringRedisTemplate.getValueSerializer());
		System.out.println("stringRedisTemplate="+stringRedisTemplate.getValueSerializer());

		/*将stringRedisTemplate序列化类设置成RedisTemplate的序列化类*/
		stringRedisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());
		stringRedisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

		System.out.println("stringRedisTemplate="+stringRedisTemplate.getValueSerializer());
		System.out.println("stringRedisTemplate="+stringRedisTemplate.getValueSerializer());

		User user1 = (User)  redisTemplate.opsForHash().get("user:","2");
		User user2 = (User) stringRedisTemplate.opsForHash().get("user:","2");
		System.out.println("user1="+user1+"user2="+user2);
	}

}