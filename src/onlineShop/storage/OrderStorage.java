package onlineShop.storage;

import onlineShop.enums.OrderStatus;
import onlineShop.model.Order;
import onlineShop.model.User;
import onlineShop.util.StorageSerializeUtil;

import java.io.Serializable;

public class OrderStorage implements Serializable {
    private Order[] orders = new Order[10];
    private int index = 0;

    private void extend() {
        Order[] temp = new Order[orders.length + 10];
        System.arraycopy(orders, 0, temp, 0, index);
        orders = temp;
        StorageSerializeUtil.serializeOrderStorage(this);
    }

    public void add(Order order) {
        if (index == orders.length) {
            extend();
        }
        orders[index++] = order;
        StorageSerializeUtil.serializeOrderStorage(this);
    }

    public void printOrders() {
        for (int i = 0; i < index; i++) {
            System.out.println(orders[i]);
        }
    }

    public void printOrdersByUser(User user) {
        for (int i = 0; i < index; i++) {
            if (user.equals(orders[i].getUser())) {
                System.out.println(orders[i]);
            }
        }
    }

    public void cancelById(String id) {
        for (int i = 0; i < index; i++) {
            if (orders[i].getId().equals(id)) {
                orders[i].setOrderStatus(OrderStatus.CANCELED);
            }
        }
        StorageSerializeUtil.serializeOrderStorage(this);
    }

    public Order findOrderById(String id) {
        for (int i = 0; i < index; i++) {
            if (orders[i].getId().equals(id)) {
                return orders[i];
            }
        }
        return null;
    }
}
