package com.syb.game;
import java.sql.*;

/**
 * @author ShiYabin
 * @create 2021-12-11 17:24
 * 备注:北京理工大学计算机学院JAVA程序设计结课作业——背景类
 */

public class ShowData {
    public static void main(String[] args) {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:./game.db");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from game");
            //输出结果
            while(rs.next()){
                System.out.println("-------");
                System.out.println("time = "+rs.getString("time"));
                System.out.println("score = "+rs.getInt("score"));
            }
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