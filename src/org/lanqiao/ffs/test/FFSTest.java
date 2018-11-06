package org.lanqiao.ffs.test;

import org.junit.Test;
import org.lanqiao.ffs.controller.loginFramController;
import org.lanqiao.ffs.dao.IProductDao;
import org.lanqiao.ffs.dao.IRegisterDao;
import org.lanqiao.ffs.dao.IUserDao;
import org.lanqiao.ffs.dao.impl.ProductDaoImpl;
import org.lanqiao.ffs.dao.impl.RegisterDaoImpl;
import org.lanqiao.ffs.dao.impl.UserDaoDaoImpl;
import org.lanqiao.ffs.entity.Product;
import org.lanqiao.ffs.entity.User;
import org.lanqiao.ffs.services.IProductService;
import org.lanqiao.ffs.services.impl.ProductServiceImpl;
import org.lanqiao.ffs.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class FFSTest {

    public static void main(String[] args){

    }

    @Test
    //测试能否链接到数据源
    public void JDBCUtilsTest(){
        System.out.println(JDBCUtils.getDataSource());
    }

    @Test
    //根据用户名和密码查询
    public void getUserByUsernameAndPasswordTest() throws SQLException {
        IUserDao iUserDao = new UserDaoDaoImpl();
        User user = new User();
        user.setUsername("火女");
        user.setPassword("344");
        System.out.println(iUserDao.getUserByUsernameAndPassword(user.getUsername(),user.getPassword()));
    }

    @Test
    //验证码测试
    public void checkcodeTest(){
        loginFramController loginController = new loginFramController();
        loginController.checkcode();
    }

    @Test
    //添加：用户
    public void addUserTest() throws SQLException {
        IRegisterDao iRegisterDao = new RegisterDaoImpl();
        iRegisterDao.addUser("猴子","233");
    }

    @Test
    //查询：根据用户名和密码
    public void  ifRegisterTest() throws SQLException {
        IRegisterDao iRegisterDao = new RegisterDaoImpl();
       boolean registerFlag = iRegisterDao.ifRegister("火女","344");
       System.out.println(registerFlag);
    }

    @Test
    //添加：商品
    public void  insertProductTest() throws SQLException {
        IProductDao iProductDao = new ProductDaoImpl();
        iProductDao.insertProduct(3,"七匹狼","服装","山西","普元",333,"2018-08-09 12:0:0",199.33);

    }

    @Test
    //查询
    public void QueryDataTest() throws SQLException {
        /*IProductDao iProductDao = new ProductDaoImpl();
        List<Product> productList = iProductDao.QueryData();
        for (Product str:productList){
            System.out.println(str);
        }*/
    }

    @Test
    //查询：service层的
    public void  getDataTest(){
       /* IProductService iProductService = new ProductServiceImpl();
        List<Product> productList = iProductService.getData();
        for (Product str:productList){
            System.out.println(str);
        }*/
    }

    @Test
    //删除
    public void deleteDataByIdTest() throws SQLException {
        IProductDao iProductDao = new ProductDaoImpl();
        iProductDao.deleteDataById(7);
    }

    @Test
    //删除:service层
    public void deleteDataServiceByIdTest(){
       /* IProductService iProductService = new ProductServiceImpl();
        iProductService.deleteDataById(8);*/
    }

    /*@Test
    //分页:查询
    public void queryTest() throws SQLException {
        IProductDao iProductDao = new ProductDaoImpl();
        List<Product> productList  = iProductDao.query(2);
        for (Product str:productList){
            System.out.println(str);
        }
    }*/

    @Test
    //获取总记录数
    public void getTotalByDateTest() throws SQLException {
        IProductDao iProductDao = new ProductDaoImpl();
         int totle = iProductDao.getTotalByDate("2018-01-01 00:00:00","2018-10-22 00:00:00");
         System.out.println(totle);
    }

    @Test
    //查询：分页
    public void getProductByDateTest() throws SQLException {
       /* IProductDao iProductDao = new ProductDaoImpl();
        List<Product> list =iProductDao.getProductByDate("2018-01-01 00:00:00","2018-10-22 23:00:00",1,5);
        for (Product str:list){
            System.out.println(str);
        }*/
    }
}
