package com.mj.dao;

import com.mj.pojo.User;

import java.util.List;

/**
 * @author : MaJ
 * @date : 2021/11/8
 * @description ：
 */
public interface UserMapper {

    List<User> getUserList();

    User getUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
