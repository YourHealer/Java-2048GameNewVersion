package com.syb.game;

import java.awt.*;

/**
 * @author ShiYabin
 * @create 2021-12-10 09:19
 * 备注:北京理工大学计算机学院JAVA程序设计结课作业——道具魔方类
 */

//道具魔方类Cubes
public class Cubes {
    //get方法 获取魔方数量
    public int getCubesNum() {
        return CubesNum;
    }

    //set方法 修改魔方数量
    public void setCubesNum(int cubesNum) {
        CubesNum = cubesNum;
    }

    //魔方数量
    private int CubesNum = 1;
    //魔方图片
    Image Cubes = Toolkit.getDefaultToolkit().getImage("Images/银色魔方.png");

    //绘制文本
    public static void drawText(Graphics g, int size, Color color, String s, int x, int y,Font fontinfo) {
        //设置文本颜色
        g.setColor(color);
        //设置字体
        g.setFont(fontinfo);
        //绘制文本
        g.drawString(s, x, y);
    }

    public void CubePaint(Graphics g){
        //绘制魔方
        g.drawImage(Cubes,370,300,null);
        //调用drawText方法绘制文本
        drawText(g,24,new Color(255, 255, 255),"*"+CubesNum,450,360,new Font("楷体", Font.BOLD, 24));
    }
}