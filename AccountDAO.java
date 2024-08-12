/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rini.bank.dao;

import com.rini.bank.bean.AccountBean;
import com.rini.bank.util.DBUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hp
 */
public class AccountDAO {
    static Connection conn;
    public boolean createNewAccount(AccountBean ac){
        conn=DBUtil.connectDB();
        boolean b=false;
        int r=0;
        String sql="insert into account_tbl values('"+ac.getAccount_Number()+"','"+ac.getCustomer_name()+"','"+ac.getBalance()+"')";
        try {
            Statement stmt =conn.createStatement();
            r=stmt.executeUpdate(sql);
            if(r>0){
                b=true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
 return b;
    }
    public AccountBean loginCheck(String userName,String password) {
        conn=DBUtil.connectDB();
        AccountBean ab=new AccountBean();
        String sql="select * from account_tbl where un='"+userName+"' and ps='"+password+"')";
        
        try {
           Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
       if(rs.next()){
           ab.setAccount_Number(rs.getString("accountNumber"));
           ab.setCustomer_name(rs.getString("customerName"));
           ab.setBalance(rs.getDouble("balance"));
           
       }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return ab;
    }
    
}
