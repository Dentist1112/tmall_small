package com.how2java.tmall.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMall {
    public  static  void  main(String args[]){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
            Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmall_ssm?useUnicode=true&characterEncoding=utf8",
                    "root",
                    "123456");
            Statement s =connection.createStatement();
        ){
            for (int i=0;i<100;i++){
            String sqlFormat= "insert into category value(null,'测试分类%d')";
            String sql=String.format(sqlFormat,i);
            s.execute(sql);
                 }
                 System.out.println("创建数据成功");
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
