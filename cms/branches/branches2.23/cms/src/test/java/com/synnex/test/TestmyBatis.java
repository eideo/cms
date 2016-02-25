package com.synnex.test;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  

import com.sbiao360.cms.domain.User;
import com.sbiao360.cms.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})  
public class TestmyBatis {
        
	 private static Logger logger = Logger.getLogger(TestmyBatis.class);  
	  
	 @Resource   
	 private UserService userService;  

	 @Test  
	 public void test1() {  
		     User user= userService.selectByPrimaryKey(1);  
		     logger.info(user.getUsername());
		     System.out.println(user.getUsername());

	 }  

	 
}
