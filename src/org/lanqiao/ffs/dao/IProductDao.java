package org.lanqiao.ffs.dao;

import org.lanqiao.ffs.entity.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IProductDao {
    //添加：商品
    public void insertProduct(int id, String pname, String sort, String bornPlace, String supplier, int count, String intime, double price) throws SQLException;
    //查询:无条件
    public List<Product> QueryData() throws SQLException;
    //查询：分页
    public List<Product> getProductByDate(String beginDate, String endDate, int currentPage, int pageSize) throws SQLException;
    // 获取记录总数
    public int getTotalByDate(String beginDate, String endDate) throws SQLException;
    //删除
    public void deleteDataById(int id) throws SQLException;

}
