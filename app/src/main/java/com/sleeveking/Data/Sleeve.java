package com.sleeveking.Data;

public class Sleeve {
    public Sleeve(String SKU, String width, String height, String price, String link, String name) {
        this.SKU = SKU;
        this.width = width;
        this.height = height;
        this.price = price;
        this.link = link;
        this.name = name;
    }

    public String getSKU() {
        return SKU;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }

    public String getPrice() {
        return price;
    }

    public String getLink() {
        return link;
    }

    String SKU;
    String width;
    String height;
    String price;
    String link;

    public String getName() {
        return name;
    }

    String name;

}
