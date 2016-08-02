
package com.shilpa.recordfilter.entity;


public class Course {
   private int c_id;
    private double price;
    private String name;

    public Course() {
    }

   /* public Course(int c_id, double price, String name) {
        this.c_id = c_id;
        this.price = price;
        this.name = name;      
    }*/

    public int getC_Id() {
        return c_id;
    }

    public void setC_Id(int c_id) {
        this.c_id = c_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}

