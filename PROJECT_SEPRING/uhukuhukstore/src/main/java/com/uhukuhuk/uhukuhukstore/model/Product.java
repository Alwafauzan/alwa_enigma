package com.uhukuhuk.uhukuhukstore.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String brand;
    private String cartegory;
    private double price;

    @Column(columnDefinition = "TEXT")
    private String description;
    private Date created_at;
    private String imageFileName;

    public Product(int id, String name, String brand, String cartegory, double price, String description,
            Date created_at, String imageFileName) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.cartegory = cartegory;
        this.price = price;
        this.description = description;
        this.created_at = created_at;
        this.imageFileName = imageFileName;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCartegory() {
        return cartegory;
    }

    public void setCartegory(String cartegory) {
        this.cartegory = cartegory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", cartegory=" + cartegory + ", price="
                + price + ", description=" + description + ", created_at=" + created_at + ", imageFileName="
                + imageFileName + "]";
    }

}
