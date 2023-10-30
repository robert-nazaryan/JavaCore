package onlineShop.model;

import onlineShop.enums.ProductType;

import java.util.UUID;

public class Product {
    private String id;
    private String name;
    private String description;
    private double price;
    private int stockQty;
    private ProductType productType;

    public Product(String name, String description, double price, int stockQty, ProductType productType) {
        id = UUID.randomUUID().toString().substring(0, 5);
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQty = stockQty;
        this.productType = productType;
    }

    public void updateProductQty(int qty) {
        stockQty = stockQty - qty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQty() {
        return stockQty;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stockQty=" + stockQty +
                ", productType=" + productType +
                '}';
    }
}
