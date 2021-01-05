package com.wu.jdbc.jpa.test;

import com.wu.jdbc.jpa.JdbcModulMain;
import com.wu.jdbc.jpa.domain.p.UserRepository;
import com.wu.jdbc.jpa.domain.p.User;
import com.wu.jdbc.jpa.domain.s.MessageRepository;
import com.wu.jdbc.jpa.domain.s.Message;
import org.aspectj.weaver.ast.Var;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= JdbcModulMain.class)
public class JdbcModulMainTests {

	//Spring-data-jpa支持
	@Autowired
	private UserRepository userRepository;

	//Spring-data-jpa支持
	@Autowired
	private MessageRepository messageRepository;

	@Test
	public void test() throws Exception {
		List<User> userList = userRepository.findAll();
		for (User user : userList) {
			System.out.println(userList);
		}
		System.out.println("__________________________________");
		List<Message> messageList = messageRepository.findAll();
		for (Message message : messageList) {
			System.out.println(message);
		}

	}


}