package onlineShop.storage;

import onlineShop.enums.OrderStatus;
import onlineShop.model.Order;
import onlineShop.model.User;

public class OrderStorage {
    private Order[] orders = new Order[10];
    private int index = 0;

    private void extend() {
        Order[] temp = new Order[orders.length + 10];
        System.arraycopy(orders, 0, temp, 0, index);
        orders = temp;
    }

    public void add(Order order) {
        if (index == orders.length) {
            extend();
        }
        orders[index++] = order;
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
