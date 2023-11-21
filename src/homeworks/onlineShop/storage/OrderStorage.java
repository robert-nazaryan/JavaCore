package homeworks.onlineShop.storage;

import homeworks.onlineShop.enums.OrderStatus;
import homeworks.onlineShop.model.Order;
import homeworks.onlineShop.model.User;
import homeworks.onlineShop.util.StorageSerializeUtil;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class OrderStorage implements Serializable {
    private List<Order> orders = new LinkedList<>();

    public void add(Order order) {
        orders.add(order);
        StorageSerializeUtil.serializeOrderStorage(this);
    }

    public void printOrders() {
        System.out.println(orders);
    }

    public void printOrdersByUser(User user) {
        for (Order order : orders) {
            if (order.getUser().equals(user)) {
                System.out.println(order);
            }
        }
    }

    public void cancelById(String id) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                order.setOrderStatus(OrderStatus.CANCELED);
            }
        }
        StorageSerializeUtil.serializeOrderStorage(this);
    }

    public Order findOrderById(String id) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        return null;
    }

}
