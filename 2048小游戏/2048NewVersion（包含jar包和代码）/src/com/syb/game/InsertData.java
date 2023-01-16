package com.syb.game;

import java.sql.*;

/**
 * @author ShiYabin
 * @create 2021-12-11 17:24
 * 备注:北京理工大学计算机学院JAVA程序设计结课作业——背景类
 */

public class InsertData {
    public void insertInfo(String timeInfo,String scoreInfo) {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:./game.db");
            Statement statement = connection.createStatement();
            //用sql记录添加语句
            String sql ="insert into game(time,score) values ("+timeInfo+','+scoreInfo+')';
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try{
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}