package com.sikiedu.sb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sikiedu.sb.entity.User;

public interface UserDao {
	
	//insert into user(id,username,password) values(id,username,password)
	//增
	int addUser1(@Param("username")String username,@Param("password")String password);
	int addUser2(User user);
	
	//删
	//delete from user where id=?
	int deleteUserById1(int id);
	int deleteUserById2(@Param("Lain")int xxx);//xxx为别名
	//改
	int updateUser(User user);
	
	//查
	List<User> searchAllUsers();
	//select * from user where id=?
	User searchUserById(int id);

}
