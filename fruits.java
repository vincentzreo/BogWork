package com.example.vz.bogwork;


import org.litepal.crud.LitePalSupport;

public class fruits extends LitePalSupport {
    private int id;
    private String name;
    private int numbers;
    private double price;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
