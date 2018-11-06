package org.lanqiao.ffs.dao;

import java.sql.SQLException;

public interface IRegisterDao {
    //用于完成用户的注册
    //添加：用户
    public void addUser(String username, String password) throws SQLException;
    //查询:根据用户名和密码
    public boolean ifRegister(String username,String password) throws SQLException;

}
