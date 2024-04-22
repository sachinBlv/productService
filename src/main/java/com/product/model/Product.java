package com.product.model;

import jakarta.persistence.*;

@Entity
@Table(name="productTable")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemid  ;   	//1001
    private String itemname ;  // 	Samsung E450
    private String  category;       //	mobile
    private double price  ;    	//45000
    private String dop;

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDop() {
        return dop;
    }

    public void setDop(String dop) {
        this.dop = dop;
    }

    @Override
    public String toString() {
        return "Product{" +
                "itemid=" + itemid +
                ", itemname='" + itemname + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", dop='" + dop + '\'' +
                '}';
    }

    public Product(int itemid, String itemname, String category, double price, String dop) {
        this.itemid = itemid;
        this.itemname = itemname;
        this.category = category;
        this.price = price;
        this.dop = dop;
    }

    public Product() {
        super();
    }
}
