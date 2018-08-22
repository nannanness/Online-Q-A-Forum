package org.lanqiao.oqaf.domain;

import java.util.Objects;


public class User {
    private int user_Id;
    private String user_Name;
    private String pass_Word;
    private String user_Sex;
    private String user_Img;
    private String user_Details;
    private String user_phone;
    private String user_school;
    private String user_city;
    private String user_bgc;

    public User() {
    }

    public User(int user_Id, String user_Name, String pass_Word, String user_Sex, String user_Img, String user_Details, String user_phone, String user_school, String user_city, String user_bgc) {
        this.user_Id = user_Id;
        this.user_Name = user_Name;
        this.pass_Word = pass_Word;
        this.user_Sex = user_Sex;
        this.user_Img = user_Img;
        this.user_Details = user_Details;
        this.user_phone = user_phone;
        this.user_school = user_school;
        this.user_city = user_city;
        this.user_bgc = user_bgc;
    }

    public User(String user_Name, String pass_Word, String user_Sex, String user_Img, String user_Details, String user_phone, String user_school, String user_city, String user_bgc) {
        this.user_Name = user_Name;
        this.pass_Word = pass_Word;
        this.user_Sex = user_Sex;
        this.user_Img = user_Img;
        this.user_Details = user_Details;
        this.user_phone = user_phone;
        this.user_school = user_school;
        this.user_city = user_city;
        this.user_bgc = user_bgc;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getPass_Word() {
        return pass_Word;
    }

    public void setPass_Word(String pass_Word) {
        this.pass_Word = pass_Word;
    }

    public String getUser_Sex() {
        return user_Sex;
    }

    public void setUser_Sex(String user_Sex) {
        this.user_Sex = user_Sex;
    }

    public String getUser_Img() {
        return user_Img;
    }

    public void setUser_Img(String user_Img) {
        this.user_Img = user_Img;
    }

    public String getUser_Details() {
        return user_Details;
    }

    public void setUser_Details(String user_Details) {
        this.user_Details = user_Details;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_school() {
        return user_school;
    }

    public void setUser_school(String user_school) {
        this.user_school = user_school;
    }

    public String getUser_city() {
        return user_city;
    }

    public void setUser_city(String user_city) {
        this.user_city = user_city;
    }

    public String getUser_bgc() {
        return user_bgc;
    }

    public void setUser_bgc(String user_bgc) {
        this.user_bgc = user_bgc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return user_Id == user.user_Id &&
                Objects.equals(user_Name, user.user_Name) &&
                Objects.equals(pass_Word, user.pass_Word) &&
                Objects.equals(user_Sex, user.user_Sex) &&
                Objects.equals(user_Img, user.user_Img) &&
                Objects.equals(user_Details, user.user_Details) &&
                Objects.equals(user_phone, user.user_phone) &&
                Objects.equals(user_school, user.user_school) &&
                Objects.equals(user_city, user.user_city) &&
                Objects.equals(user_bgc, user.user_bgc);
    }

    @Override
    public int hashCode() {

        return Objects.hash(user_Id, user_Name, pass_Word, user_Sex, user_Img, user_Details, user_phone, user_school, user_city, user_bgc);
    }

    @Override
    public String toString() {
        return "User{" +
                "user_Id=" + user_Id +
                ", user_Name='" + user_Name + '\'' +
                ", pass_Word='" + pass_Word + '\'' +
                ", user_Sex='" + user_Sex + '\'' +
                ", user_Img='" + user_Img + '\'' +
                ", user_Details='" + user_Details + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_school='" + user_school + '\'' +
                ", user_city='" + user_city + '\'' +
                ", user_bgc='" + user_bgc + '\'' +
                '}';
    }
}
