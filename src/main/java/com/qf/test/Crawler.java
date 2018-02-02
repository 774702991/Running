package com.qf.test;

import java.sql.Connection;
import java.sql.Statement;

public class Crawler {

    private static Connection connection;
    private static Statement statement;



    public static void main(String[] args) {

        Integer a = 200;
        Integer s = 200;
        if (a == s){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

        if (a.intValue() == s.intValue()){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
