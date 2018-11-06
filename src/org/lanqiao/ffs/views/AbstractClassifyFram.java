package org.lanqiao.ffs.views;

import org.lanqiao.ffs.utils.GUITools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class AbstractClassifyFram extends Frame{
    private Font font = new Font("华文彩云",Font.BOLD,18);
    //    JPanel mainFrame = new JPanel();
    private JLabel logoimg = new JLabel();//背景图
    private JButton replenishButton =new JButton();//进货管理
    private JButton saleButton =new JButton();//销售管理
    private JButton storeButton =new JButton();//存储管理
    public AbstractClassifyFram(){
        init();
        addCommpant();
        addListener();
    }
    //初始化
    private void init(){
        Image icon = Toolkit.getDefaultToolkit().getImage("imgs/1.jpg");
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

//        ImageIcon icon = new ImageIcon("imgs/1.jpg");
        JPanel mainFrame = new BackImgPanel("imgs/b.png");
        mainFrame.setLayout(null);
//        mainFrame.add(backImgPanel);
//        icon.setImage(icon.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT));
//        logoimg.setIcon(icon);
//        logoimg.setBounds(0,0,600,150);
//        mainFrame.add(logoimg);
        replenishButton.setText("进货管理");
        replenishButton.setFont(font);
//        replenishButton.setBackground(new Color(43,154,225));
//        replenishButton.setOpaque(false);
        replenishButton.setBounds(200,160,200,40);
        replenishButton.setBorder(null);
        replenishButton.setContentAreaFilled(false);
        mainFrame.add(replenishButton);

        saleButton.setText("销售管理");
        saleButton.setFont(font);
//        saleButton.setBackground(new Color(43,154,225));
        saleButton.setBounds(200,210,200,40);
        saleButton.setBorder(null);
        saleButton.setContentAreaFilled(false);
        mainFrame.add(saleButton);

        storeButton.setText("存储管理");
        storeButton.setFont(font);
//        storeButton.setBackground(new Color(43,154,225));
        storeButton.setBounds(200,260,200,40);
        storeButton.setBorder(null);
        storeButton.setContentAreaFilled(false);
        mainFrame.add(storeButton);
        this.add(mainFrame);
    }
    public void addListener(){
        replenishButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                replenish();
            }
        });
        saleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sale();
            }
        });
        storeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                store();
            }
        });

    }
    public  abstract void replenish();
    public  abstract void sale();
    public  abstract void store();
}
