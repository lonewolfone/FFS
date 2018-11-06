package org.lanqiao.ffs.services;

import org.lanqiao.ffs.entity.Product;

import java.util.List;

public interface IProductService {
    //查询
    public List<Product> getData();
    //删除
    public void deleteDataById(int id);
    //添加
    public void insertPro(int id, String pname, String sort, String bornPlace, String supplier, int count, String intime, double price);

}
