package org.lanqiao.ffs.app;

import org.lanqiao.ffs.controller.addProductController;
import org.lanqiao.ffs.controller.loginFramController;
import org.lanqiao.ffs.controller.mainController;
import org.lanqiao.ffs.views.AbstractAddProductFrame;
import org.lanqiao.ffs.views.AbstractLoginFram;
import org.lanqiao.ffs.views.AbstractMainFram;

public class Main {
    public static void main(String[] args){
        AbstractLoginFram abstractLoginFram = new loginFramController();
        abstractLoginFram.setVisible(true);
        /*AbstractClassificationFram ab = new AbstractClassificationFram();
        ab.setVisible(true);*/
        /*AbstractMainFrame abstractMainFrame = new AbstractMainFrame();
        abstractMainFrame.setVisible(true);*/
       /* AbstractMainFram abstractMainFram =new mainController();
        abstractMainFram.setVisible(true);*/


    }
}
