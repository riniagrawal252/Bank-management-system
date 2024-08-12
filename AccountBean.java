/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rini.bank.bean;

/**
 *
 * @author Hp
 */
public class AccountBean {
  private String Account_Number;
private String customer_name;
private double balance;

    public AccountBean() {
    }

    public AccountBean(String Account_Number, String customer_name, double balance) {
        this.Account_Number = Account_Number;
        this.customer_name = customer_name;
        this.balance = balance;
    }

    public String getAccount_Number() {
        return Account_Number;
    }

    public void setAccount_Number(String Account_Number) {
        this.Account_Number = Account_Number;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
