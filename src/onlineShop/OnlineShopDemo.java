package onlineShop;

import onlineShop.enums.OrderStatus;
import onlineShop.enums.PaymentMethod;
import onlineShop.enums.ProductType;
import onlineShop.enums.UserType;
import onlineShop.exceptions.OutOfStockException;
import onlineShop.interfaces.*;
import onlineShop.model.Order;
import onlineShop.model.Product;
import onlineShop.model.User;
import onlineShop.storage.OrderStorage;
import onlineShop.storage.ProductStorage;
import onlineShop.storage.UsersStorage;

import java.util.Scanner;

public class OnlineShopDemo implements AdminManuCommands, AuthorizationCommands, OrderStatusCommands,
        UserManuCommands, ProductTypeCommands, RegisterCommands {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ProductStorage productStorage = new ProductStorage();
    private static final UsersStorage usersStorage = new UsersStorage();
    public static final OrderStorage orderStorage = new OrderStorage();
    private static boolean isRun = true;

    public static void main(String[] args) {
        while (isRun) {
            authorization();
        }
    }

    private static void authorization() {
        System.out.println("Enter " + LOGIN + " for LOGIN");
        System.out.println("Enter " + REGISTER + " for REGISTER");
        System.out.println("Enter " + EXIT + " for EXIT");
        switch (scanner.nextLine()) {
            case LOGIN:
                login();
                break;
            case REGISTER:
                register();
                break;
            case EXIT:
                isRun = false;
                break;

            default:
                System.out.println("Invalid command! Try again");
                authorization();
                break;
        }
    }

    private static void login() {
        System.out.println("Enter user EMAIL");
        String email = scanner.nextLine();
        if (usersStorage.isRegisteredEmail(email)) {
            System.out.println("Enter use PASSWORD");
            String password = scanner.nextLine();
            if (usersStorage.isValidPassword(email, password)) {
                showMenu(usersStorage.findUserByEmail(email));
            } else {
                System.out.println("Wrong password! Try again");
                login();
            }
        } else {
            System.out.println("This email isn't registered");
            System.out.println("Do you want register now? y/n");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                register();
            } else {
                authorization();
            }
        }

    }

    private static void showMenu(User user) {
        if (user.getType() == UserType.ADMIN) {
            adminMenu();
        } else {
            userMenu(user);
        }
    }

    private static void adminMenu() {
        boolean isRun = true;
        while (isRun) {
            adminMenuCommands();
            switch (scanner.nextLine()) {
                case AdminManuCommands.LOGOUT:
                    isRun = false;
                    authorization();
                    break;
                case ADD_PRODUCT:
                    addProduct();
                    break;
                case REMOVE_PRODUCT_BY_ID:
                    System.out.println("Enter product ID");
                    productStorage.removeProductById(scanner.nextLine());
                    break;
                case AdminManuCommands.PRINT_PRODUCTS:
                    productStorage.print();
                    break;
                case PRINT_USERS:
                    usersStorage.printUsers();
                    break;
                case PRINT_ORDERS:
                    orderStorage.printOrders();
                    break;
                case CHANGE_ORDER_STATUS:
                    changeOrderStatus();
                    break;


            }
        }
    }

    private static void changeOrderStatus() {
        orderStorage.printOrders();
        System.out.println("Enter order ID");
        Order order = orderStorage.findOrderById(scanner.nextLine());
        for (OrderStatus value : OrderStatus.values()) {
            System.out.println("Enter " + value.ordinal() + " for change status to " + value.name());
        }
        switch (scanner.nextLine()) {
            case NEW:
                order.setOrderStatus(OrderStatus.NEW);
                break;
            case DELIVERED:
                order.setOrderStatus(OrderStatus.DELIVERED);
                order.getProduct().updateProductQty(order.getQty());
                break;
            case CANCELED:
                order.setOrderStatus(OrderStatus.CANCELED);
                break;
            default:
                System.out.println("Wrong command! Try again.");
                changeOrderStatus();
                break;
        }
    }


    private static void addProduct() {
        System.out.println("Chose product type");
        for (ProductType value : ProductType.values()) {
            System.out.println("Enter " + value.ordinal() + " for " + value.name());
        }
        ProductType productType = null;
        switch (scanner.nextLine()) {
            case ELECTRONICS:
                productType = ProductType.ELECTRONICS;
                break;
            case CLOTHING:
                productType = ProductType.CLOTHING;
                break;
            case BOOKS:
                productType = ProductType.BOOKS;
                break;
            default:
                System.out.println("Invalid command! Try again");
                addProduct();
                break;
        }
        System.out.println("Enter product NAME");
        String name = scanner.nextLine();
        System.out.println("Enter product DESCRIPTION");
        String description = scanner.nextLine();
        System.out.println("Enter product PRICE");
        String price = scanner.nextLine();
        System.out.println("Enter product STOCK QUANTITY");
        String stockQty = scanner.nextLine();
        productStorage.add(new Product(name, description, Double.parseDouble(price), Integer.parseInt(stockQty), productType));
    }

    private static void userMenu(User user) {
        userMenuCommands();
        switch (scanner.nextLine()) {
            case UserManuCommands.LOGOUT:
                authorization();
                break;
            case UserManuCommands.PRINT_PRODUCTS:
                productStorage.print();
                userMenu(user);
                break;
            case BUY_PRODUCTS:
                buyProduct(user);
                break;
            case PRINT_MY_ORDERS:
                orderStorage.printOrdersByUser(user);
                userMenu(user);
                break;
            case CANCEL_ORDER_BY_ID:
                cancelOrderById(user);
                break;
        }
    }

    private static void cancelOrderById(User user) {
        orderStorage.printOrdersByUser(user);
        System.out.println("Enter order ID");
        orderStorage.cancelById(scanner.nextLine());
        userMenu(user);
    }

    private static void buyProduct(User user) {
        productStorage.print();
        System.out.println("Enter product ID");
        String id = scanner.nextLine();
        int qty = 0;
        Product product = productStorage.findProductById(id);
        try {
            qty = productQtyValidator(product);
        } catch (OutOfStockException e) {
            System.out.println(e);
            buyProduct(user);
        } catch (NumberFormatException e) {
            System.out.println("Quantity must be an integer! Try again");
            buyProduct(user);
        }
        System.out.println("Do you want buy " + qty + " " + product.getName() + " for price " +
                qty * product.getPrice() + "? y/n");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            PaymentMethod payMth = chosePayMethod();
            orderStorage.add(new Order(user, product, payMth, qty));
        }
        userMenu(user);
    }

    private static PaymentMethod chosePayMethod() {
        System.out.println("Chose payment method");
        for (PaymentMethod value : PaymentMethod.values()) {
            System.out.println("Enter " + value.ordinal() + " for " + value);
        }
        try {
            int command = Integer.parseInt(scanner.nextLine());
            for (PaymentMethod value : PaymentMethod.values()) {
                if (command == value.ordinal()) {
                    return value;
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Wrong command! Try again!");
            chosePayMethod();
        }
        return null;
    }

    private static int productQtyValidator(Product product) throws OutOfStockException {
        if (product != null) {
            System.out.println("Enter QUANTITY");
            String stQty = scanner.nextLine();
            int qty = Integer.parseInt(stQty);
            if (qty <= product.getStockQty() && qty > 0) {
                return qty;
            }
        }
        throw new OutOfStockException();
    }

    private static void adminMenuCommands() {
        System.out.println("Enter " + AdminManuCommands.LOGOUT + " for LOGOUT");
        System.out.println("Enter " + ADD_PRODUCT + " for ADD PRODUCT");
        System.out.println("Enter " + REMOVE_PRODUCT_BY_ID + " for REMOVE PRODUCT BY ID");
        System.out.println("Enter " + AdminManuCommands.PRINT_PRODUCTS + " for PRINT PRODUCT");
        System.out.println("Enter " + PRINT_USERS + " for PRINT USERS");
        System.out.println("Enter " + PRINT_ORDERS + " for PRINT ORDERS");
        System.out.println("Enter " + CHANGE_ORDER_STATUS + " for CHANGE ORDER STATUS");
    }

    private static void userMenuCommands() {
        System.out.println("Enter " + UserManuCommands.LOGOUT + " for LOGOUT");
        System.out.println("Enter " + UserManuCommands.PRINT_PRODUCTS + " for PRINT PRODUCTS");
        System.out.println("Enter " + BUY_PRODUCTS + " for BUY PRODUCT");
        System.out.println("Enter " + PRINT_MY_ORDERS + " for PRINT MY ORDERS");
        System.out.println("Enter " + CANCEL_ORDER_BY_ID + " for CANCEL ORDER BY ID");
    }


    private static void register() {
        System.out.println("Enter " + ADMIN + " for ADMIN");
        System.out.println("Enter " + USER + " for USER");
        String type = scanner.nextLine();
        if (!(type.equals(ADMIN) || type.equals(USER))) {
            System.out.println("Invalid command! Try again");
            register();
        }
        System.out.println("Enter user NAME");
        String name = scanner.nextLine();
        System.out.println("Enter user EMAIL");
        String email = scanner.nextLine();
        System.out.println("Enter user PASSWORD");
        String password = scanner.nextLine();
        usersStorage.add(new User(name, email, password, type));
        System.out.println("Registration completed successfully");
        System.out.println("Do you want login now? y/n");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            login();
        } else {
            authorization();
        }
    }
}
