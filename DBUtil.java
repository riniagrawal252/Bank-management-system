/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rini.bank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hp
 */
public class DBUtil {
   static Connection  conn;
   //Member data static
   public static Connection connectDB(){
       try {
           //step1: Register The Driver
           Class.forName("com.mysql.cj.jdbc.Driver");
           //step2: Create The Connection
           String url="jdbc:mysql://localhost:3306/may24";
           String un="root";
           String ps="rini!123";
           conn=DriverManager.getConnection(url, un, ps);
           System.out.println("Database connectivity success");
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
       }
       return conn;
   }
    public static void main(String[] args) {
        connectDB();
    }

   }



