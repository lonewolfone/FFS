package org.lanqiao.ffs.views;

import org.lanqiao.ffs.entity.Product;
import org.lanqiao.ffs.utils.DateChooser;
import org.lanqiao.ffs.utils.DateUtils;
import org.lanqiao.ffs.utils.GUITools;
import org.lanqiao.ffs.utils.ListTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import  java.util.List;

public abstract class AbstractMainFram extends JFrame{
    private Font font = new Font("华文彩云",Font.BOLD,18);
    JPanel repMngFrame = new JPanel();
   protected Product delPro =new Product();
    private JLabel beginDateLable = new JLabel();//起始日期
    protected JTextField beginDateField = new JTextField();//从日历选择
    private JLabel endDateLable = new JLabel();//结束日期
    protected JTextField endDateField = new JTextField();//结束日期从日历选择
    private JLabel sortMngLable = new JLabel();//分类管理类型
    private JLabel sortLable = new JLabel();//具体分类
    protected JComboBox sortMngBox = new JComboBox();//分类管理类型下拉菜单
    protected JTextField sortText = new JTextField();//具体分类下拉菜单
    protected JTable ledgerDataTable = new JTable();
    private JButton checkButton = new JButton();
    private JButton addButton =new JButton();
    private JButton editButton =new JButton();
    private JButton deleteButton =new JButton();
    private JButton productRateButton = new JButton();
    private JButton backHomeButton = new JButton();
    ImageIcon icon = new ImageIcon("images/1.jpg");
    private JButton homePageBtn = new JButton("首页");// 首页
    protected JButton previouspageButton = new JButton("前");//上一页
    protected JButton nextpageButton = new JButton("后");//下一页
    private   JLabel firstLable = new JLabel("第");//第
    protected JTextField numberField = new JTextField();//几
    private   JLabel leftLable = new JLabel("页");//页
    protected JLabel countLabel = new JLabel();//总页数
    private JButton endPageBtn = new JButton("末页");// 末页
    protected JButton skip = new JButton("跳转");//跳转
    protected List<Product> list = new ArrayList();
    // 总记录数
    protected int total = 0;
    // 当前页数和页内数据行数
    protected int currentPage = 1;
    protected int pageSize = 10;
    public int page=0;
    public AbstractMainFram() {
        init();
        setTableModel(list);
    }
    private void init(){
        Image icon = Toolkit.getDefaultToolkit().getImage("imgs/1.jpg");
        this.setIconImage(icon);
        this.setTitle("Welcome to use IMS 进管存仓库管理系统");
        this.setSize(700,400);
        GUITools.center(this);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.addCommpant();
        this.addListener();
        this.queryData();
        this.setVisible(true);

    }
    public void addCommpant() {
        repMngFrame.setLayout(null);
        ImageIcon icon = new ImageIcon("imgs/b.png");
        //起始时间
        beginDateLable.setText("开始时间:");
        beginDateLable.setBounds(30, 10, 60, 28);
        repMngFrame.add(beginDateLable);
        beginDateField.setText(String.format("%tF", DateUtils.getFirstDayOfMethod()));
        DateChooser.getInstance().register(this.beginDateField);
        beginDateField.setBounds(100, 10, 70, 28);
        this.add(beginDateField);

        //结束时间
        endDateLable.setText("结束时间");
        endDateLable.setBounds(180, 10, 60, 28);
        repMngFrame.add(endDateLable);
        endDateField.setText(String.format("%tF", DateUtils.getFirstDayOfMethod()));
        DateChooser.getInstance().register(this.endDateField);
        endDateField.setBounds(250, 10, 70, 28);
        repMngFrame.add(endDateField);

        //管理类型
        sortMngLable.setText("分类");
        sortMngLable.setBounds(340, 10, 35, 28);
        sortMngBox.setModel(new DefaultComboBoxModel(new Object[]{"--选择管理--","食物","家用电器","电子设备","饮品","服装"}));
        sortMngBox.setBounds(385, 10, 110, 28);
        repMngFrame.add(sortMngLable);
        repMngFrame.add(sortMngBox);

        //模糊查询
//        sortLable.setText("操作类型");
//        sortLable.setBounds(410, 10, 55, 28);
        sortText.setBounds(505, 10, 70, 28);
        repMngFrame.add(sortLable);
        repMngFrame.add(sortText);

        //检索
        checkButton.setText("检索");
        checkButton.setBounds(590, 10, 60, 28);
        checkButton.setBorder(null);
        repMngFrame.add(checkButton);


        //滚动条面板
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(25, 50, 640, 200);
        list=  queryData();

        scrollPane.setViewportView(ledgerDataTable);
        ledgerDataTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单选
        ledgerDataTable.getTableHeader().setReorderingAllowed(false);//列不能移动
        this.add(scrollPane);
        //分页
        homePageBtn.setBounds(80,260,40,28);//首页
        homePageBtn.setBorder(null);
        repMngFrame.add(homePageBtn);
        previouspageButton.setBounds(130,260,50,28);//上一页
        previouspageButton.setBorder(null);
        repMngFrame.add(previouspageButton);
        firstLable.setBounds(200,260,40,28);//第
        repMngFrame.add(firstLable);
        numberField.setBounds(220,260,40,28);//几
        numberField.setText(String.valueOf(currentPage));
        repMngFrame.add(numberField);
        leftLable.setBounds(270,260,40,28);//页
        repMngFrame.add(leftLable);
        nextpageButton.setBounds(300,260,50,28);//下一页
        repMngFrame.add(nextpageButton);
        skip.setBounds(390,260,80,28);//跳转
        repMngFrame.add(skip);
        endPageBtn.setBounds(490,260,80,28);//末页
        repMngFrame.add(endPageBtn);
        countLabel.setBounds(580,260,80,28);//总页数
        countLabel.setText("共4页");
        repMngFrame.add(countLabel);

        //添加按钮
        addButton.setText("添加");
        addButton.setBounds(25,300,100,28);
        addButton.setBorder(null);
        addButton.setBackground(Color.pink);
        repMngFrame.add(addButton);

        //编辑按钮
        editButton.setText("编辑");
        editButton.setBounds(170,300,100,28);
        editButton.setBorder(null);
        editButton.setBackground(Color.yellow);
        repMngFrame.add(editButton);
        //删除按钮
        deleteButton.setText("删除");
        deleteButton.setBounds(325,300,100,28);
        deleteButton.setBorder(null);
        deleteButton.setBackground(Color.pink);
        repMngFrame.add(deleteButton);
        //回到首页按钮
        backHomeButton.setText("回到首页");
        backHomeButton.setBounds(475,300,100,28);
        backHomeButton.setBorder(null);
        backHomeButton.setBackground(Color.yellow);
        repMngFrame.add(backHomeButton);


        this.add(repMngFrame);


        }
        public   String[] colNames = new String[] {"ID", "货物名称", "分类","货物产地","供货商", "数量",  "创建时间","价格"};
        public String[] propNames = new String[] {"id", "pname", "sort", "bornPlace", "supplier", "count", "intime","price"};
    //设置表格面板
    public void setTableModel(List<Product> proList)  {
         if(proList != null || proList.size() != 0) {
            try {
                ledgerDataTable.setModel(new ListTableModel<Product>(proList,Product.class,colNames,propNames));
            } catch (Exception e) {
                e.printStackTrace();
            }
            ledgerDataTable.setEnabled(true);
            return;
         }
    }

//获取选中行
    protected Product getSortByTableRow(int row) {
        return ((ListTableModel<Product>)ledgerDataTable.getModel()).getInstance(row);
    }
    public void addListener(){
        //检索事件
        checkButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              list=  queryData();
              setTableModel(list);
            }
        });
        //首页
        homePageBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                homePage();
            }
        });
        //上一页
        previouspageButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                prevPage();
            }
        });
        //下一页
        nextpageButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nextPage();
            }
        });
        //跳转
        skip.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jumpPage();
            }
        });
        //末页
        endPageBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                endPage();
            }
        });
        //添加事件
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                add();

            }
        });
        //编辑事件
        editButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                edit();
            }
        });
        //删除事件
        deleteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {

                    delPro = getSortByTableRow(ledgerDataTable.getSelectedRow());
                    delete(delPro.getId());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        //回到首页事件
        backHomeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backHome();
            }
        });

    }

    public abstract void add();//添加
    public abstract void edit();//编辑
    public abstract void delete(int id) throws SQLException;//删除
    public abstract void backHome();//返回
    public abstract  List<Product> queryData();//查询
    public abstract void homePage();//首页
    public abstract void prevPage();//上一页
    public abstract void nextPage();//下一页
    public abstract void endPage();//末页
    public abstract void jumpPage();//跳转
}
