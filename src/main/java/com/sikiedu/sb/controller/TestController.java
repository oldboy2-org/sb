package com.sikiedu.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sikiedu.sb.dao.UserDao;
import com.sikiedu.sb.entity.User;

@Controller
public class TestController {
	
	@Autowired
	private UserDao userDao;
	
	//localhost:8080/test
	@RequestMapping("/test")
	public String test(){
		List<User> searchAllUsers = userDao.searchAllUsers();
		for(User user : searchAllUsers){
			//1|lain|123
			//2|admin|123
			System.out.println(user.getId()+"|"+user.getUsername()+"|"+user.getPassword());
		}
		return "hello";
	}
	
	@RequestMapping("/test2")
	public String test2(){
		User user = userDao.searchUserById(1);
		System.out.println(user.getId()+"|"+user.getUsername()+"|"+user.getPassword());
		return "hello";
	}
	
	@RequestMapping("/test3")
	public String test3(){
		User user = new User();
		user.setUsername("trigger");
		user.setPassword("789");
		userDao.addUser1("trigger", "789");
		return "hello";	
	}
	
	@RequestMapping("/test4")
	public String test4(){
		User user = new User();
		user.setUsername("andy");
		user.setPassword("123");
		
		userDao.addUser2(user);
		return "hello";	
	}
	
	@RequestMapping("/test5")
	public String test5(){
		User user =userDao.searchUserById(8);
		user.setUsername("siki");
		user.setPassword("555");
		userDao.updateUser(user);
		return "hello";		
	}
	
	@RequestMapping("/test6")
	public String test6(){
		userDao.deleteUserById1(6);
		return "hello";		
	}
	
	@RequestMapping("/test7")
	public String test7(){
		userDao.deleteUserById2(7);
		return "hello";		
	}
}
