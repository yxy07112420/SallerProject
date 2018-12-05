package com.neuedu.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 用户
 */
public class User implements Serializable {
    private Integer user_id;
    private String user_Name;
    private String user_psw;
    private String user_email;
    private String user_telPhone;
    private String user_regDate;
    public User(){

    }

    public User(Integer user_id, String user_Name, String user_psw, String user_email, String user_telPhone, String user_regDate) {
        this.user_id = user_id;
        this.user_Name = user_Name;
        this.user_psw = user_psw;
        this.user_email = user_email;
        this.user_telPhone = user_telPhone;
        this.user_regDate = user_regDate;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getUser_psw() {
        return user_psw;
    }

    public void setUser_psw(String user_psw) {
        this.user_psw = user_psw;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_telPhone() {
        return user_telPhone;
    }

    public void setUser_telPhone(String user_telPhone) {
        this.user_telPhone = user_telPhone;
    }

    public String getUser_regDate() {
        return user_regDate;
    }

    public void setUser_regDate(String user_regDate) {
        this.user_regDate = user_regDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_Name='" + user_Name + '\'' +
                ", user_psw='" + user_psw + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_telPhone='" + user_telPhone + '\'' +
                ", user_regDate='" + user_regDate + '\'' +
                '}';
    }
}
