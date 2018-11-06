package org.lanqiao.ffs.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lanqiao.ffs.dao.IProductDao;
import org.lanqiao.ffs.entity.Product;
import org.lanqiao.ffs.utils.JDBCUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDaoImpl implements IProductDao {

    DataSource ds = JDBCUtils.getDataSource();
    QueryRunner queryRunner = new QueryRunner(ds);
    @Override
    //添加商品
    public void insertProduct(int id, String pname, String sort, String bornPlace, String supplier, int count, String intime, double price) throws SQLException {
        String sql = "insert into ffs_product(id,pname,sort,bornPlace,supplier,count,intime,price) values(?,?,?,?,?,?,?,?)";
        queryRunner.update(sql,id,pname,sort,bornPlace,supplier,count,intime,price);
    }

    //@Override
    public List<Product> query(int pageNo) throws SQLException {
        //每一页显示5个数据
        int pageSize= 5;
        //计算总页数    总页数= 行数 / pageSize +(行数%pageSize==0 ? 0:1)
        //总行数
        String sql = "SELECT COUNT(1) FROM ffs_product ";
        int rows = Integer.parseInt(""+queryRunner.query(sql, new ScalarHandler()));
        int pageCount = rows/pageSize  +(rows%pageSize==0? 0 : 1 ) ;

        //查询表数据
        int stratN= (pageNo-1)*pageSize;
        String sql1= "select * from ffs_product limit "+ stratN +","+ pageSize;
        List<Product> list = new ArrayList<>();
        list =queryRunner.query(sql1, new BeanListHandler<Product>(Product.class));

        return list;
    }

    @Override
    //查询：无条件
    public List<Product> QueryData() throws SQLException {
        String sql = "select * from ffs_product ";
        List<Product> list = new ArrayList<>();
        list = queryRunner.query(sql,new BeanListHandler<Product>(Product.class));
        return list;
    }
    @Override
    //查询：分页
    public List<Product> getProductByDate(String beginDate, String endDate, int currentPage, int pageSize) throws SQLException {
        List<Product> list = null;
        String sql = "select * from ffs_product where date between ? and ? ";
        String order = " order by date desc";
        //list = queryRunner.query(JDBCUtils.PagenationSql(sql+order,currentPage,pageSize),new BeanListHandler<Product>(Product.class),beginDate,endDate);
        return list;
    }
    @Override
    // 获取记录总数
    public int getTotalByDate(String beginDate, String endDate) throws SQLException {
        int total ;
        String sql = "select count(*) from ffs_product where data between ? and ?";
        total = Integer.parseInt(queryRunner.query(sql,new ScalarHandler<>(1), beginDate,endDate).toString());
        return total;
    }
    @Override
    //删除
    public void deleteDataById(int id) throws SQLException {
        String sql = "delete from ffs_product where id = ?";
        queryRunner.update(sql,id);
    }
}
