package org.lanqiao.ffs.views;

import org.lanqiao.ffs.utils.GUITools;
import org.lanqiao.ffs.utils.VerifiCodeUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class AbstractLoginFram extends JFrame {
    private Font font = new Font("黑体",Font.BOLD,16);
    private JLabel userLable = new JLabel();//用户
    private JLabel passwordLable = new JLabel();//密码
    private JLabel checkLable = new JLabel();//验证码
    private JLabel code = new JLabel();//验证码显示
    protected JTextField userFiled = new JTextField();//用户名输入框
    protected JPasswordField passwordFiled = new JPasswordField();//密码输入框
    protected  JTextField codeFiled = new JTextField();//验证码输入框
    protected JLabel message = new JLabel();//警告框
    private  JButton loginButton = new JButton();//登录按钮
    private JButton registerButton = new JButton();//注册按钮

    //构造代码块，调用初始化init方法
    public AbstractLoginFram(){
        init();
        addCommpant();
        addListener();
    }
    //初始化
    private void init(){
        Image icon = Toolkit.getDefaultToolkit().getImage("imgs/b.png");//设置图标
        this.setIconImage(icon);
        this.setTitle("Welcome to use IMS 进管存仓库管理系统");//设置标题
        this.setSize(600,400);
        GUITools.center(this);//居中
        this.setResizable(false);//不可调整窗口大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭按钮
        this.setLocationRelativeTo(null);
        this.setVisible(true);//可见
    }

    //添加组件
    public void addCommpant(){

        JPanel  loginJpanel = new BackImgPanel("imgs/b.png");
        loginJpanel.setLayout(null);//设置窗口布局
        //设置账号
        userLable.setFont(font);
        userLable.setText("账  号");

        userLable.setBounds(180,160,70,20);
        loginJpanel.add(userLable);

        //设置密码
        passwordLable.setFont(font);
        passwordLable.setText("密  码");
        passwordLable.setBounds(180,190,70,20);
        loginJpanel.add(passwordLable);

        //设置验证码
        checkLable.setFont(font);
        checkLable.setText("验证码");
        checkLable.setBounds(180,220,70,20);
        loginJpanel.add(checkLable);

        //账号输入框
        userFiled.setToolTipText("请输入账号信息");
        userFiled.setBounds(250,160,130,25);
        userFiled.setColumns(180);
        userFiled.setBorder(null);
        //userFiled.setOpaque(false);
        loginJpanel.add(userFiled);

        //密码输入框
        passwordFiled.setToolTipText("请输入密码");
        passwordFiled.setBounds(250,190,130,25);
        passwordFiled.setColumns(180);
        passwordFiled.setBorder(null);
        loginJpanel.add(passwordFiled);


        //验证码图片
        code.setBounds(320,216,130,30);
        code.setIcon(new ImageIcon(VerifiCodeUtil.getBufferdImage(180,40)));
        code.setBackground(Color.white);
        code.setToolTipText("点击更换");
        loginJpanel.add(code);

        //验证码输入框
        codeFiled.setBounds(250,220,60,25);
        codeFiled.setColumns(180);
        codeFiled.setBorder(null);
        loginJpanel.add(codeFiled);
        message.setBounds(190,250,100,25);//警告框
        message.setFont(font);
        message.setForeground(Color.RED);
        loginJpanel.add(message);

        //登录按钮
        loginButton.setText("登陆");
        loginButton.setFont(font);
//      loginButton.setBackground(new Color(43,154,225));
        loginButton.setBounds(180,300, 70,25);
        loginButton.setBorder(null);

        loginJpanel.add(loginButton);

        //注册按钮
        registerButton.setText("注册");
        registerButton.setFont(font);
        registerButton.setBounds(330,300, 70,25);
        registerButton.setBorder(null);
        loginJpanel.add(registerButton);
        this.add(loginJpanel);
    }

    //监听事件
    public void addListener(){
        code.addMouseListener(new MouseAdapter() {//验证码的监听事件，点击切换下一张
            @Override
            public void mouseClicked(MouseEvent e) {
                code.setIcon(new ImageIcon(VerifiCodeUtil.getBufferdImage(180,40)));
            }
        });
        loginButton.addMouseListener(new MouseAdapter() {//登陆监听
            @Override
            public void mouseClicked(MouseEvent e) {
                login();
            }
        });
        registerButton.addMouseListener(new MouseAdapter() {//注册监听
            @Override
            public void mouseClicked(MouseEvent e) {
                register();
            }
        });

    }
    public  abstract void login() ;//登陆
    public abstract void register() ;//注册
    public abstract boolean  checkcode();//验证码校验
}
