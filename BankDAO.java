/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rini.bank.dao;
import com.rini.bank.bean.TransferBean;
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
public class BankDAO {
static Connection conn;
    

    public boolean validateAccount(String accountNumber) {
        conn=DBUtil.connectDB();
        boolean isValid = false;

    
           
            String sql = "SELECT * FROM ACCOUNT_TBL WHERE ACCOUNT_NUMBER = '"+accountNumber+"'";
           
           
            try {
            //step4: Create Object of Statement
            Statement stmt = conn.createStatement();
            //step5: call executeQuery
            ResultSet rs = stmt.executeQuery(sql);
            //step6: Process Result
            
        isValid=rs.next();
            //step7: Close the Connections
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BankDAO.class.getName()).log(Level.SEVERE, null, ex);
        } // Check if any row is returned
     

        return isValid;
    }

    public double findBalance(String accountNumber) {
        conn=DBUtil.connectDB();
        
        double balance = 0; 
            String sql = "SELECT BALANCE FROM ACCOUNT_TBL WHERE ACCOUNT_NUMBER = '"+accountNumber+"'";
           
 

           TransferBean sb=new TransferBean();
        try {
            //step4: Create Object of Statement
            Statement stmt=conn.createStatement();
            //step5: call executeQuery
            ResultSet rs=stmt.executeQuery(sql);
            //step6: Process Result
           
          if(rs.next()){
                
             balance=rs.getDouble("balance");
             
          }
            //step7: Close the Connections
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BankDAO.class.getName()).log(Level.SEVERE, null, ex);
        }


        return balance;
    }
     public boolean updateBalance(String accountNumber, double newBalance) {
        conn=DBUtil.connectDB();
      
boolean success = false;
        
            
            String sql = "UPDATE ACCOUNT_TBL SET BALANCE = '"+newBalance+"' WHERE ACCOUNT_NUMBER ='"+accountNumber+"'";
            
        try {
            //step4: Create Object of Statement
            Statement stmt=conn.createStatement();
            //step5: call executeUpdate
           int r=stmt.executeUpdate(sql);
           success=(r>0);
            //step6: close the Connection
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BankDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
    

    public boolean transferMoney(TransferBean tb)  {
        conn=DBUtil.connectDB();
        
        boolean success = false;
        BankDAO bd=new BankDAO();
        // Validate sender's and receiver's account numbers
        if (bd.validateAccount(tb.getAccount_Number()) && bd.validateAccount(tb.getBeneficiary_Account_Number())){
           
           double fromAmount = bd.findBalance(tb.getAccount_Number());
            System.out.println("From Amount Balance"+fromAmount);
                    double tamount=Double.parseDouble(tb.getTransaction_amount());
              System.out.println("tamount"+tamount);
              if(fromAmount>tamount){
                  bd.updateBalance(tb.getAccount_Number(),fromAmount-tamount);
                  bd.updateBalance(tb.getBeneficiary_Account_Number(), bd.findBalance(tb.getBeneficiary_Account_Number()+tamount));             
            int tid=(int)(Math.random()*100000);
              
            String sql="insert into transfer_tbl values('"+tid+"','"+tb.getAccount_Number()+"','"+tb.getBeneficiary_Account_Number()+"','"+tb.getTransaction_Date()+"','"+tb.getTransaction_amount()+"')";
            
             Connection conn=DBUtil.connectDB();
                try {
                    
                   Statement stmt = conn.createStatement();
                
            int x=stmt.executeUpdate(sql);
            if(x>0){
            success= true;
            }
            conn.close();
            } catch (SQLException ex) {
                    Logger.getLogger(BankDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
              }
           
        }
    
       
        return success;  
   
        
    }

    
        
    
    
    


   
    
    
    public static void main(String[] args) {
        BankDAO bankDAO = new BankDAO();
        TransferBean tb = new TransferBean();
     
        tb.setAccount_Number("1234567890");
        tb.setBeneficiary_Account_Number("1234567891");
        tb.setTransaction_amount("1");
        tb.setTransaction_Date("8-June-2024");
                
       // int sequenceNumber = bankDAO.generateSequenceNumber();
       // System.out.println("Generated Sequence Number: " + sequenceNumber);
       // String accountNumberToValidate = "1234567890";

// Call the validateAccount method

//String accountNumberToValidate = "1234567890";
//boolean isValidAccount = bankDAO.validateAccount(accountNumberToValidate);
//
//// Use the result of validation as needed
//if (isValidAccount) {
//    System.out.println("Account is valid.");
//} else {
//    System.out.println("Account is not valid.");
//}
//String accountNumberToFindBalanceFor = "1234567890";
//
//// Call the findBalance method
//float balance = bankDAO.findBalance(accountNumberToFindBalanceFor);
//
//// Check if the returned balance is valid (-1 indicates an error)
//if (balance != -1) {
//    System.out.println("Balance for account " + accountNumberToFindBalanceFor + ": " + balance);
//} else {
//    System.out.println("Error: Unable to find balance for account " + accountNumberToFindBalanceFor);
//}
        // Create and populate TransferBean instance
        
        // Create an instance of BankDAO
       

        // Call transferMoney method
        boolean b = bankDAO.transferMoney(tb);

        System.out.println("Amount Transfer Success"+b);
    }

}

    
    


    
            
    
    
   
    
  
    

 


    
   
    


    

