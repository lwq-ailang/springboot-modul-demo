package com.wu.jdbc.jpa;

import com.wu.jdbc.jpa.dao.UserDetailRepository;
import com.wu.jdbc.jpa.pojo.UserDetail;
import com.wu.jdbc.jpa.pojo.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailRepositoryTests {

	@Autowired
	private UserDetailRepository userDetailRepository;

	@Test
	public void testSaveUserDetail() {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		UserDetail userDetail=new UserDetail();
		userDetail.setUserId(3L);
		userDetail.setHobby("吃鸡游戏");
		userDetail.setAge(28);
		userDetail.setIntroduction("一个爱玩的人");
		userDetailRepository.save(userDetail);
	}

	@Test
	public void testUserInfo()  {
		List<UserInfo> userInfos=userDetailRepository.findUserInfo("钓鱼");
		for (UserInfo userInfo:userInfos){
			System.out.println("userInfo: "+userInfo.getUserName()+"-"+userInfo.getEmail()+"-"+userInfo.getHobby()+"-"+userInfo.getIntroduction());
		}
	}
}