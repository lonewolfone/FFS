package org.lanqiao.ffs.controller;

import org.lanqiao.ffs.services.IRegisterService;
import org.lanqiao.ffs.services.IUserService;
import org.lanqiao.ffs.services.impl.RegisterServiceImpl;
import org.lanqiao.ffs.services.impl.UserServiceImpl;
import org.lanqiao.ffs.utils.VerifiCodeUtil;
import org.lanqiao.ffs.views.AbstractLoginFram;

import javax.swing.*;

public class loginFramController extends AbstractLoginFram {

    private IUserService iUserService = new UserServiceImpl();
    private String username;
    private String password;

    @Override
    //登陆
    public void login() {
        username = this.userFiled.getText().trim();
        password = new String(this.passwordFiled.getPassword());
        boolean codeFlag = checkcode();
        boolean loginFlag = false;
        if (username != null && !"".equalsIgnoreCase(username) && password != null && !"".equalsIgnoreCase(password)){
                loginFlag = iUserService.login(username,password);
                if(codeFlag){

                    if (loginFlag && codeFlag){
                        JOptionPane.showMessageDialog(this,"登陆成功","小溪温馨提示",JOptionPane.INFORMATION_MESSAGE);
                         this.setVisible(false);
                       new classifyController();//通过子类继承，实例化子类的时候抽象类也会被实例化。
                    }else {
                        if(loginFlag){
                            JOptionPane.showMessageDialog(this,"校验码错误，请确认后重新登陆","小溪温馨提示",JOptionPane.ERROR_MESSAGE);
                        }else {
                            JOptionPane.showMessageDialog(this,"用户名或密码错误，请重新登陆","小溪温馨提示",JOptionPane.ERROR_MESSAGE);
                        }
                    }

                }else {
                    JOptionPane.showMessageDialog(this,"校验码为空，请输入后登陆","小溪温馨提示",JOptionPane.ERROR_MESSAGE);
                }
        }else {
            JOptionPane.showMessageDialog(this,"用户名或密码为空，请确认后重新登陆","小溪温馨提示",JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    //注册
    public void register() {
        IRegisterService iRegisterService = new RegisterServiceImpl();
        username = this.userFiled.getText().trim();
        password = new String(this.passwordFiled.getPassword());
        boolean codeFlag = checkcode();
        boolean ifRegis = false;
        ifRegis = iRegisterService.ifRegister(username,password);
        if (username != null && !"".equalsIgnoreCase(username) && password != null && !"".equalsIgnoreCase(password)){
            if( codeFlag){
                if(ifRegis){
                    JOptionPane.showMessageDialog(this, "注册成功", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
                   }else{
                    JOptionPane.showMessageDialog(this, "用户名已存在，请直接登陆", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
                    }
            }else {
                JOptionPane.showMessageDialog(this,"校验码错误或为空，请输入后注册","小溪温馨提示",JOptionPane.ERROR_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(this,"用户名或密码为空，请确输入后进行注册","小溪温馨提示",JOptionPane.ERROR_MESSAGE);
        }


    //new registerFrameComplete();
    }

    @Override
    //检验校验码
    public boolean checkcode() {
        String genCode = VerifiCodeUtil.getCode();//校验码
        String userCode = codeFiled.getText().trim();//用户输入的校验码
        if (userCode != null && !userCode.equals("")) {
            if (!userCode.equalsIgnoreCase(genCode)) {
                message.setText("验证码有误，请重新输入！");
                return false;
            } else {
                return true;
            }
        } else {
            //message.setText("验证码不能为空！");
            return false;

        }
    }
}
