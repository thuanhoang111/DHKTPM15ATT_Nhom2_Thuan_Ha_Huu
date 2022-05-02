package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.Serializable;


public class Customer  {
    private String lopHP;
    private String name;
    private String email;
    private int imgCustomer;

    public Customer(String lopHP, String name, String email, int imgCustomer) {
        this.lopHP = lopHP;
        this.name = name;
        this.email = email;
        this.imgCustomer = imgCustomer;
    }

    public Customer(String lopHP, String name, String email) {
        this.lopHP = lopHP;
        this.name = name;
        this.email = email;
    }

    public String getLopHP() {
        return lopHP;
    }

    public void setLopHP(String lopHP) {
        this.lopHP = lopHP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getImgCustomer() {
        return imgCustomer;
    }

    public void setImgCustomer(int imgCustomer) {
        this.imgCustomer = imgCustomer;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "lopHP='" + lopHP + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", imgCustomer=" + imgCustomer +
                '}';
    }
}