package com.syb.game;

import java.awt.*;

/**
 * @author ShiYabin
 * @create 2021-12-07 14:29
 * 备注:北京理工大学计算机学院JAVA程序设计结课作业——基本信息接口
 */

//基本信息接口BasicInfo
public interface BasicInfo {
    //字体Font部分
    //标题内容字体 65号 楷体 加粗
    Font topicFont = new Font("楷体", Font.BOLD, 65);
    //提示内容字体 45号 华文新魏 加粗
    Font reminderFont = new Font("华文新魏",Font.BOLD, 45);
    //规则内容字体 17号 楷体 加粗
    Font ruleFont = new Font("楷体",Font.BOLD, 17);
    //建议内容字体 17号 楷体 加粗
    Font suggestFont = new Font("楷体",Font.BOLD, 17);
    //分数内容字体 20号 楷体 加粗
    Font markFont = new Font("楷体",Font.BOLD, 20);
    //超小号字体 35号 楷体 加粗
    Font fontExtraSmallSize = new Font("楷体", Font.BOLD, 35);
    //小号字体 40号 楷体 加粗
    Font fontSmallSize = new Font("楷体", Font.BOLD, 40);
    //中号字体 45号 楷体 加粗
    Font fontMiddleSize = new Font("楷体", Font.BOLD, 45);
    //大号字体 50号 楷体 加粗
    Font fontLargeSize = new Font("楷体", Font.BOLD, 50);

    //颜色Color部分
    //标签部分颜色 0xEE1F0BFF
    Color colorLabelOne = new Color(238, 31, 11);
    //规则部分颜色 0xFE612DFF
    Color colorLabelRule = new Color(255, 0, 0);
    //建议部分颜色 0xFE612DFF
    Color colorSuggestRule = new Color(255, 64, 0);
    //提示分数背景颜色 0x232323
    Color colorReminderMarkBg = new Color(35,35,35);

    //抽象方法，用于展示界面，使Frame可视
    void showView();
    //抽象方法，用于游戏初始化
    void Game();
}