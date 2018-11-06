package org.lanqiao.ffs.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.lanqiao.ffs.dao.IUserDao;
import org.lanqiao.ffs.entity.User;
import org.lanqiao.ffs.utils.JDBCUtils;

import javax.sql.DataSource;
import java.sql.SQLException;

public class UserDaoDaoImpl implements IUserDao {
    @Override
    //根据用户名和密码查询
    public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
        /*使用QueryRunner类实现CRUD,queryRunner类中的构造方法需要一个数据源，
           在工具类中，提供一个获取 DataSource(数据源) 的方法*/
        DataSource dataSource = JDBCUtils.getDataSource();
        //创建一个QueryRunner对象（由JDBCUtils工具类提供一个数据源）
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "select * from ffs_user where username =? and password = ? ";
        User user =queryRunner.query(sql,new BeanHandler<>(User.class),username,password);
        return user;
    }
}
