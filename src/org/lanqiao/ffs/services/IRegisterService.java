package org.lanqiao.ffs.services;




public interface IRegisterService {
    //用于完成用户的注册
    //添加：用户
    public void addUser(String username, String password);
    //查询:根据用户名和密码
    public boolean ifRegister(String username,String password);
}
