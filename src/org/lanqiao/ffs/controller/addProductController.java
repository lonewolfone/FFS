package org.lanqiao.ffs.controller;

import org.lanqiao.ffs.services.IProductService;
import org.lanqiao.ffs.services.impl.ProductServiceImpl;
import org.lanqiao.ffs.views.AbstractAddProductFrame;

import javax.swing.*;

public class addProductController extends AbstractAddProductFrame {
    IProductService iProductService = new ProductServiceImpl();

    @Override
    public void ack() {
        String textId = this.productIdField.getText().trim();//编号
        String textCount = this.productCountField.getText().trim();//产品数量
        double textPrice = Double.parseDouble(this.productSalePriceField.getText().trim());//产品价格
        int id =0;
        int count =0;
//        double price=0.0;
        String pname = this.productNameField.getText().trim();//货物名称
        String sort = (String) this.productSortField.getSelectedItem();//分类
        String bornPlace=this.productBornPlaceField.getText().trim();//产地
        String supplier = this.productSupplierField.getText().trim();//供应商
        String intime=this.productTimeField.getText().trim();
        this.setVisible(false);
        if(textId != null && !textId.equals("") &&textCount != null && !textCount.equals("")){
            id = Integer.parseInt(textId);
            count = Integer.parseInt(textCount);
           //price = textPrice;
            iProductService.insertPro(id,pname,sort,bornPlace,supplier,count,intime,textPrice);

        }else{
            JOptionPane.showMessageDialog(this, "用户名或密码为空，请确认后重新登陆", "小溪温馨提示", JOptionPane.WARNING_MESSAGE);
        }

    }

    @Override
    public void cancel() {
        this.setVisible(false);
        new mainController();
    }
}
