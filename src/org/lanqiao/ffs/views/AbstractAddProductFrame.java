package org.lanqiao.ffs.views;

import org.lanqiao.ffs.entity.Product;
import org.lanqiao.ffs.utils.DateChooser;
import org.lanqiao.ffs.utils.DateUtils;
import org.lanqiao.ffs.utils.GUITools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class AbstractAddProductFrame extends Frame {
    public Product product = new Product();
    private Font font = new Font("华文彩云",Font.BOLD,18);
    private JLabel productNameLable = new JLabel();//产品名称
    private JLabel productIdLable = new JLabel();//编号
    private JLabel productSupplierLable = new JLabel();//产品供应商
    private JLabel productBornPlaceLable = new JLabel();//产地
    private JLabel productCountLable = new JLabel();//产品数量
    private JLabel productSalePriceLable = new JLabel();//价格
    private JLabel productTimeLable = new JLabel();//时间
    private JLabel productSortLable = new JLabel();//分类
    private JButton ackButton = new JButton();//确认
    private JButton cancelButton = new JButton();//取消
    protected JComboBox productSortField = new JComboBox();//分类下拉框
    protected JTextField productNameField = new JTextField();//产品名输入框
    protected JTextField productIdField = new JTextField();//编号输入框
    protected JTextField productSupplierField = new JTextField();//供应商输入框
    protected JTextField productBornPlaceField = new JTextField();//产地输入框
    protected JTextField productCountField = new JTextField();//产品数量输入框
    protected JTextField productSalePriceField = new JTextField();//产品价格输入框
    protected JTextField productTimeField = new JTextField();//入库时间输入框
    public AbstractAddProductFrame (){
        init();
        addListener();

    }
    public void init(){
        Image icon = Toolkit.getDefaultToolkit().getImage("imgs/b.png");
        this.setIconImage(icon);
        this.setTitle("Welcome to use IMS 进管存仓库管理系统");
        this.setSize(600,400);
        GUITools.center(this);
        this.setResizable(false);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.addCommpant();
        this.setVisible(true);

    }
    public void addCommpant(){
        JPanel addProductPanel = new BackImgPanel("imgs/1.png");
        addProductPanel.setLayout(null);
        ImageIcon icon = new ImageIcon("imgs/1.jpg");
        //货物名称
        productNameLable.setText("货物名称");
        productNameLable.setBounds(50,50,55,28);
        addProductPanel.add(productNameLable);
        productNameField.setBounds(110,50,100,28);
        addProductPanel.add(productNameField);

        //货物分类
        productSortLable.setText("货物分类");
        productSortLable.setBounds(50,100,55,28);
        addProductPanel.add(productSortLable);
        productSortField.setBounds(110,100,100,28);
        productSortField.setModel(new DefaultComboBoxModel(new Object[]{"食物","家用电器","电子设备","饮品"}));
        addProductPanel.add(productSortField);

        //货物编号
        productIdLable.setText("货物编号");
        productIdLable.setBounds(50,150,55,28);
        addProductPanel.add(productIdLable);
        productIdField.setBounds(110,150,100,28);
//        productIdField.setText();
        addProductPanel.add(productIdField);

        //供应商
        productSupplierLable.setText("供应商");
        productSupplierLable.setBounds(50,200,55,28);
        addProductPanel.add(productSupplierLable);
        productSupplierField.setBounds(110,200,100,28);
        addProductPanel.add(productSupplierField);

        //产地
        productBornPlaceLable.setText("产地");
        productBornPlaceLable.setBounds(300,50,55,28);
        addProductPanel.add(productBornPlaceLable);
        productBornPlaceField.setBounds(360,50,100,28);
        addProductPanel.add(productBornPlaceField);

        //数量
        productCountLable.setText("数量");
        productCountLable.setBounds(300,100,55,28);
        addProductPanel.add(productCountLable);
        productCountField.setBounds(360,100,100,28);
        addProductPanel.add(productCountField);

        //价格
        productSalePriceLable.setText("价格");
        productSalePriceLable.setBounds(300,150,55,28);
        addProductPanel.add(productSalePriceLable);
        productSalePriceField.setBounds(360,150,100,28);
        addProductPanel.add(productSalePriceField);

        //时间
        productTimeLable.setText("时间");
        productTimeLable.setBounds(300,200,55,28);
        addProductPanel.add(productTimeLable);
        productTimeField.setBounds(360,200,100,28);
        addProductPanel.add(productTimeField);

        //确认按钮
        ackButton.setText("确认");
        ackButton.setBounds(100,260,100,28);
        addProductPanel.add(ackButton);
        //取消按钮
        cancelButton.setText("取消");
        cancelButton.setBounds(300,260,100,28);
        addProductPanel.add(cancelButton);
        this.setText();
        this.add(addProductPanel);


    }
    public void addListener(){
        ackButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ack();

            }
        });
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cancel();
            }
        });
    }
    public abstract void ack();
    public abstract void cancel();
    public void setText(){
        productNameField.setText(String.valueOf(product.getPname()));
        productSortField.setSelectedItem(product.getSort());
        productIdField.setText(String.valueOf(product.getId()));
        productSupplierField.setText(product.getSupplier());
        productBornPlaceField.setText(product.getBornPlace());
        productCountField.setText(String.valueOf(product.getCount()));
        productSalePriceField.setText(String.valueOf(product.getPrice()));
        productTimeField.setText(String.format("%tF", DateUtils.getFirstDayOfMethod()));
        DateChooser.getInstance().register(this.productTimeField);
    }
}
