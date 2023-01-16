package com.syb.game;

import java.awt.*;

/**
 * @author ShiYabin
 * @create 2021-12-10 20:55
 * 备注:北京理工大学计算机学院JAVA程序设计结课作业——道具炸弹类
 */

//道具炸弹类Bombs
public class Bombs {
    //get方法 获取炸弹数量
    public int getBombsNum() {
        return BombsNum;
    }

    //set方法 修改炸弹数量
    public void setBombsNum(int bombsNum) {
        BombsNum = bombsNum;
    }

    //炸弹数量
    private int BombsNum = 1;
    //炸弹图片
    Image Bombs = Toolkit.getDefaultToolkit().getImage("Images/炸弹.png");

    //绘制文本
    public static void drawText(Graphics g, int size, Color color, String s, int x, int y,Font fontinfo) {
        //设置文本颜色
        g.setColor(color);
        //设置字体
        g.setFont(fontinfo);
        //绘制文本
        g.drawString(s, x, y);
    }

    public void BombPaint(Graphics g){
        //绘制炸弹
        g.drawImage(Bombs,370,130,null);
        //调用drawText方法绘制文本
        drawText(g,24,new Color(255, 255, 255),"*"+BombsNum,440,210,new Font("楷体", Font.BOLD, 24));
    }
}