package org.lanqiao.ffs.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.lanqiao.ffs.dao.IRegisterDao;
import org.lanqiao.ffs.entity.User;
import org.lanqiao.ffs.utils.JDBCUtils;

import javax.sql.DataSource;
import java.sql.SQLException;

public class RegisterDaoImpl implements IRegisterDao {

    DataSource ds = JDBCUtils.getDataSource();
    QueryRunner queryRunner = new QueryRunner(ds);
    @Override
    //添加：用户
    public void addUser(String username, String password) throws SQLException {
        String sql = "insert into ffs_user(username,password) values(?,?)";
        queryRunner.update(sql,username,password);
    }

    @Override
    //查询：根据用户名和密码
    //若返回值为true，则用户已经注册，此次注册失败；若返回值为false，则添加用户，注册成功
    public boolean ifRegister(String username, String password) throws SQLException {
        String sql = "select * from ffs_user where username = ? and password = ?";
        User registerFlag = null;
        registerFlag = queryRunner.query(sql,new BeanHandler<>(User.class),username,password);
        if (registerFlag != null){
            return false;
        }else {
            addUser(username,password);
            return true;
        }

    }

}
