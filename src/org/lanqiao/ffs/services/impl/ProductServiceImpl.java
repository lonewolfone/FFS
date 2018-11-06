package org.lanqiao.ffs.services.impl;

import org.lanqiao.ffs.dao.IProductDao;
import org.lanqiao.ffs.dao.impl.ProductDaoImpl;
import org.lanqiao.ffs.entity.Product;
import org.lanqiao.ffs.services.IProductService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    IProductDao iProductDao = new ProductDaoImpl();
    @Override
    //查询：进行商品的展示
    public List<Product> getData() {
        List<Product> list = new ArrayList<>();
        try {
            list =iProductDao.QueryData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    //删除
    public void deleteDataById(int id) {
        try {
            iProductDao.deleteDataById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    //添加
    public void insertPro(int id, String pname, String sort, String bornPlace, String supplier, int count, String intime, double price) {
        try {
            iProductDao.insertProduct(id,pname,sort,bornPlace,supplier,count,intime,price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
