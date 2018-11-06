package org.lanqiao.ffs.services.impl;

import org.lanqiao.ffs.dao.IUserDao;
import org.lanqiao.ffs.dao.impl.UserDaoDaoImpl;
import org.lanqiao.ffs.entity.User;
import org.lanqiao.ffs.services.IUserService;

import java.sql.SQLException;

public class UserServiceImpl implements IUserService {
    private IUserDao iUserDao = new UserDaoDaoImpl();
    @Override
    //查询用户:根据用户名和密码
    public boolean login(String username, String password) {
        User user = null;
        try {
            user = iUserDao.getUserByUsernameAndPassword(username,password);
            if (user != null){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
