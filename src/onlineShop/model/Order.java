package onlineShop.model;

import onlineShop.enums.OrderStatus;
import onlineShop.enums.PaymentMethod;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Order implements Serializable {
    private String id;
    private User user;
    private Product product;
    private Date date;
    private double price;
    private OrderStatus orderStatus;
    private int qty;
    private PaymentMethod paymentMethod;
    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy hh:mm");


    public Order(User user, Product product, PaymentMethod paymentMethod, int qty) {
        this.user = user;
        this.product = product;
        this.paymentMethod = paymentMethod;
        this.qty = qty;
        id = UUID.randomUUID().toString().substring(0, 5);
        price = qty * product.getPrice();
        date = new Date();
        orderStatus = OrderStatus.NEW;
    }

    public User getUser() {
        return user;
    }

    public String getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQty() {
        return qty;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", product=" + product +
                ", date=" + SDF.format(date) +
                ", price=" + price +
                ", orderStatus=" + orderStatus +
                ", qty=" + qty +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
