package com.syb.game;

import java.awt.*;

/**
 * @author ShiYabin
 * @create 2021-12-09 20:53
 * 备注:北京理工大学计算机学院JAVA程序设计结课作业——道具爆竹类
 */

//道具爆竹类FireCrackers
public class FireCrackers {
    //get方法 获取爆竹数量
    public int getFirecrackersNum() {
        return firecrackersNum;
    }

    //set方法 获取爆竹数量
    public void setFirecrackersNum(int firecrackersNum) {
        this.firecrackersNum = firecrackersNum;
    }

    //爆竹数量
    private int firecrackersNum = 1;
    //爆竹图片
    Image firecracks = Toolkit.getDefaultToolkit().getImage("Images/爆竹.png");

    //绘制文本
    public static void drawText(Graphics g, int size, Color color, String s, int x, int y,Font fontinfo) {
        //设置文本颜色
        g.setColor(color);
        //设置字体
        g.setFont(fontinfo);
        //绘制文本
        g.drawString(s, x, y);
    }

    public void ToolPaint(Graphics g){
        //绘制爆竹
        g.drawImage(firecracks,390,10,null);
        //调用drawText方法绘制文本
        drawText(g,24,new Color(255, 255, 255),"*"+ firecrackersNum,440,60,new Font("楷体", Font.BOLD, 24));
    }
}