package com.wu.jdbc.jpa;

import com.wu.jdbc.jpa.pojo.UserDetail;
import com.wu.jdbc.jpa.pojo.UserDetailParam;
import com.wu.jdbc.jpa.service.UserDetailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaSpecificationTests {

	@Autowired
	private UserDetailService userDetailService;

	@Test
	public void testFindByCondition()  {
		int page=0,size=10;
		//Sort sort = new Sort(Sort.Direction.DESC, "id");//springboot2.2.1（含）以上的版本Sort已经不能再实例化了，构造方法已经是私有的了！
		Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
		UserDetailParam param=new UserDetailParam();
		param.setIntroduction("程序员");
		param.setMinAge(10);
		param.setMaxAge(30);
		Page<UserDetail> page1=userDetailService.findByCondition(param,pageable);
		for (UserDetail userDetail:page1){
			System.out.println("userDetail: "+userDetail.toString());
		}
	}

}