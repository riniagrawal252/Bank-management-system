/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rini.bank.bean;

import java.util.Date;

/**
 *
 * @author Hp
 */
public class TransferBean {
   private int transaction_id;
    private String Account_Number;
    private String Beneficiary_Account_Number;
    private String Transaction_Date;
    private String transaction_amount;

    public TransferBean() {
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getAccount_Number() {
        return Account_Number;
    }

    public void setAccount_Number(String Account_Number) {
        this.Account_Number = Account_Number;
    }

    public String getBeneficiary_Account_Number() {
        return Beneficiary_Account_Number;
    }

    public void setBeneficiary_Account_Number(String Beneficiary_Account_Number) {
        this.Beneficiary_Account_Number = Beneficiary_Account_Number;
    }

    public String getTransaction_Date() {
        return Transaction_Date;
    }

    public void setTransaction_Date(String Transaction_Date) {
        this.Transaction_Date = Transaction_Date;
    }

    public String getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(String transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public TransferBean(int transaction_id, String Account_Number, String Beneficiary_Account_Number, String Transaction_Date, String transaction_amount) {
        this.transaction_id = transaction_id;
        this.Account_Number = Account_Number;
        this.Beneficiary_Account_Number = Beneficiary_Account_Number;
        this.Transaction_Date = Transaction_Date;
        this.transaction_amount = transaction_amount;
    }

}