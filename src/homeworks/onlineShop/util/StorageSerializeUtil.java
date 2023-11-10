package homeworks.onlineShop.util;

import homeworks.onlineShop.storage.OrderStorage;
import homeworks.onlineShop.storage.ProductStorage;
import homeworks.onlineShop.storage.UserStorage;

import java.io.*;

public class StorageSerializeUtil {
    private static final String ORDERS_FILE_PATH = "D:\\Java\\JavaCore\\src\\homeworks.onlineShop\\data\\orderStorage.dat";
    private static final String PRODUCTS_FILE_PATH = "D:\\Java\\JavaCore\\src\\homeworks.onlineShop\\data\\productStorage.dat";
    private static final String USERS_FILE_PATH = "D:\\Java\\JavaCore\\src\\homeworks.onlineShop\\data\\userStorage.dat";

    public static void serializeOrderStorage(OrderStorage orderStorage) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(ORDERS_FILE_PATH))) {
            outputStream.writeObject(orderStorage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static OrderStorage deserializeOrderStorage() {
        File file = new File(ORDERS_FILE_PATH);
        if (!file.exists()) {
            return new OrderStorage();
        }
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(ORDERS_FILE_PATH))) {
            if (inputStream.readObject() instanceof OrderStorage orderStorage) {
                return orderStorage;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new OrderStorage();
    }

    public static void serializeProductStorage(ProductStorage productStorage) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(PRODUCTS_FILE_PATH))) {
            outputStream.writeObject(productStorage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ProductStorage deserializeProductStorage() {
        File file = new File(PRODUCTS_FILE_PATH);
        if (!file.exists()) {
            return new ProductStorage();
        }
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(PRODUCTS_FILE_PATH))) {
            if (inputStream.readObject() instanceof ProductStorage productStorage) {
                return productStorage;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ProductStorage();
    }

    public static void serializeUserStorage(UserStorage userStorage) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(USERS_FILE_PATH))) {
            outputStream.writeObject(userStorage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static UserStorage deserializeUserStorage() {
        File file = new File(USERS_FILE_PATH);
        if (!file.exists()) {
            return new UserStorage();
        }
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(USERS_FILE_PATH))) {
            if (inputStream.readObject() instanceof UserStorage userStorage) {
                return userStorage;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new UserStorage();
    }
}
