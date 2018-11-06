package org.lanqiao.ffs.views;

import javax.swing.*;
import java.awt.*;

public class BackImgPanel extends JPanel {
    ImageIcon icon ;
    Image img;
    public BackImgPanel(String imgPath){
        icon = new ImageIcon(imgPath);
        img = icon.getImage();
    }
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
    }
}
