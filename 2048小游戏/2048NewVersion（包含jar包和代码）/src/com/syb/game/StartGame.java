package com.syb.game;

/**
 * @author ShiYabin
 * @create 2021-12-08 15:04
 * 备注:北京理工大学计算机学院JAVA程序设计结课作业——背景类
 */

//游戏启动类StartGame
public class StartGame {
    public static void main(String[] args) {
        //背景音乐启动
        Music audioPlayWave = new Music("John Dreamer - Rise (上升).wav");
        audioPlayWave.start();
        @SuppressWarnings("unused")
        int musicOpenLab = 1;

        //创建游戏对象 调用展示界面方法
        GameFrame window=new GameFrame();
        window.showView();
    }
}