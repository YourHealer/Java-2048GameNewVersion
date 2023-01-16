package com.syb.game;

import java.awt.Color;
import java.awt.Font;

/**
 * @author ShiYabin
 * @create 2021-12-09 18:30
 * 备注:北京理工大学计算机学院JAVA程序设计结课作业——方格类
 */

//方格类Block
public class Block{
    //成员变量 int型 value
    public int value;

    //构造器
    public Block() {
    }

    //方法 getFontColor 根据value值返回字体颜色
    public Color getFontColor() {
        switch (value) {
            case 0:
                //选择暗黑色，符合底板颜色
                return new Color(0x232323);
            default:
                //选择白色字体
                return new Color(0xFFFFFFFF);
        }
    }

    //方法 getScreenColor 根据value值返回背景色
    public Color getScreenColor() {
        switch (value) {
            case 0:
                return new Color(0x232323);
            case 2:
                return new Color(0xFF7B7B);
            case 4:
                return new Color(0xFF7272);
            case 8:
                return new Color(0xFF6868);
            case 16:
                return new Color(0xFE5B5B);
            case 32:
                return new Color(0xFF5151);
            case 64:
                return new Color(0xFE4646);
            case 128:
                return new Color(0xFF3333);
            case 256:
                return new Color(0xFE2727);
            case 512:
                return new Color(0xFF0F0F);
            case 1024:
                return new Color(0xFF0909);
            case 2048:
                return new Color(0xFF0000);
            case 4096:
                return new Color(0xED0000);
            case 8192:
                return new Color(0xD80000);
            default:
                return new Color(0x7F0000);
        }
    }

    //方法 getBlockFont
    //鉴于内容长度不同，需要根据文本长度适当更改字号
    //根据value值返回字体 防止因数字位数过大导致块内数字无法完全显示
    public Font getBlockFont() {
        if (value < 128) {
            //两位及以下数字用大号字体
            return BasicInfo.fontLargeSize;
        }
        if (value < 1024) {
            //三位数字用中号字体
            return BasicInfo.fontMiddleSize;
        }
        if(value < 16384){
            //四位数字用小号字体
            return BasicInfo.fontSmallSize;
        }
        //五位及以上用超小号字体
        return BasicInfo.fontExtraSmallSize;
    }

}