package org.lanqiao.ffs.dao;

import org.lanqiao.ffs.entity.User;

import java.sql.SQLException;

public interface IUserDao {
    //查询：根据用户名和密码，用于完成用户的登陆功能
    public User getUserByUsernameAndPassword(String username, String password) throws SQLException;
}
