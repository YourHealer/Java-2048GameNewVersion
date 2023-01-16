package com.syb.game;

import java.awt.*;

/**
 * @author ShiYabin
 * @create 2021-12-08 15:01
 * 备注:北京理工大学计算机学院JAVA程序设计结课作业——背景类
 */

//背景类Background
public class Background {
    //背景图片
    Image background = Toolkit.getDefaultToolkit().getImage("Images/火星底图.png");

    public void BackgroundPaint(Graphics g){
        //绘制背景图
        g.drawImage(background,0,0,null);
    }
}