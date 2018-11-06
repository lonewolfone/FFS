package org.lanqiao.ffs.services.impl;

import org.lanqiao.ffs.dao.IRegisterDao;
import org.lanqiao.ffs.dao.impl.RegisterDaoImpl;
import org.lanqiao.ffs.services.IRegisterService;

import java.sql.SQLException;

public class RegisterServiceImpl implements IRegisterService {
    IRegisterDao iRegisterDao = new RegisterDaoImpl();

    @Override
    //添加：用户
    public void addUser(String username, String password) {
        try {
            iRegisterDao.addUser(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    //查询:根据用户名和密码
    public boolean ifRegister(String username, String password) {
        boolean registerFlag = false;
        try {
            registerFlag = iRegisterDao.ifRegister(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registerFlag;
    }
}
