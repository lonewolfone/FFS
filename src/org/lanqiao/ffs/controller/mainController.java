package org.lanqiao.ffs.controller;

import org.lanqiao.ffs.entity.Product;
import org.lanqiao.ffs.services.IProductService;
import org.lanqiao.ffs.services.impl.ProductServiceImpl;
import org.lanqiao.ffs.utils.ListTableModel;
import org.lanqiao.ffs.views.AbstractAddProductFrame;
import org.lanqiao.ffs.views.AbstractMainFram;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class mainController extends AbstractMainFram {
    IProductService iProductService = new ProductServiceImpl();
    String t1 =null;
    String t2 = null;
    String sortMng =null;
    String sort = null;
    @Override
    //添加
    public void add() {
        new addProductController();
    }

    @Override
    //编辑
    public void edit() {
        AbstractAddProductFrame addProductFrame = new addProductController();//添加面板
        //将选中的数据放到一个product对象中
        try {
            addProductFrame.product = new ListTableModel<>(list,Product.class,colNames,propNames).getInstance(ledgerDataTable.getSelectedRow());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //对表中数据重新赋值
        addProductFrame.setText();
    }

    @Override
    //删除
    public void delete(int id) throws SQLException {
        IProductService iProductService = new ProductServiceImpl();
        int ifDelete = JOptionPane.showConfirmDialog(null,"确认删除","温馨提示",JOptionPane.YES_NO_CANCEL_OPTION);
        if(ifDelete==JOptionPane.YES_OPTION){
            iProductService.deleteDataById(id);
            JOptionPane.showMessageDialog(null,"删除成功");
            queryData();
        }
    }

    @Override
    //返回
    public void backHome() {
        this.setVisible(false);
        new classifyController();
    }

    @Override
    //查询:商品的展示
    public List<Product> queryData() {
        IProductService iProductService = new ProductServiceImpl();
        list = iProductService.getData();
        return list;

    }

    @Override
    public void homePage() {

    }

    @Override
    public void prevPage() {

    }

    @Override
    public void nextPage() {

    }

    @Override
    public void endPage() {

    }

    @Override
    public void jumpPage() {

    }
}
