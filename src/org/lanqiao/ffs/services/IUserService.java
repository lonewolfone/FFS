package org.lanqiao.ffs.services;

public interface IUserService {
    //查询用户:根据用户名和密码，用于完成用户的登陆
    public boolean login(String username,String password);

}
