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
public class UsersBean {
    private int uid;
    private String name;
    private String username;
    private String password;

    public UsersBean() {
    }

    public UsersBean(int uid, String name, String username, String password) {
        this.uid = uid;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
