package homeworks.onlineShop.storage;

import homeworks.onlineShop.enums.UserType;
import homeworks.onlineShop.model.User;
import homeworks.onlineShop.util.StorageSerializeUtil;

import java.io.Serializable;

public class UserStorage implements Serializable {
    private User[] users = new User[10];
    private int index = 0;

    private void extend() {
        User[] temp = new User[users.length + 10];
        System.arraycopy(users, 0, temp, 0, index);
        users = temp;
        StorageSerializeUtil.serializeUserStorage(this);
    }

    public void print() {
        for (int i = 0; i < index; i++) {
            System.out.println(users[i].toString());
        }
    }

    public void add(User user) {
        if (index == users.length) {
            extend();
        }
        users[index++] = user;
        StorageSerializeUtil.serializeUserStorage(this);
    }

    public User findUserByEmail(String email) {
        for (int i = 0; i < index; i++) {
            if (users[i].getEmail().equals(email)) {
                return users[i];
            }
        }
        return null;
    }

    public boolean isRegisteredEmail(String email) {
        if (index == 0) {
            return false;
        }
        for (int i = 0; i < index; i++) {
            if (users[i].getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidPassword(String email, String password) {
        for (int i = 0; i < index; i++) {
            if (users[i].getEmail().equals(email)) {
                if (users[i].getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void printUsers() {
        for (int i = 0; i < index; i++) {
            if (users[i].getType() == UserType.USER) {
                System.out.println(users[i]);
            }
        }
    }
}
