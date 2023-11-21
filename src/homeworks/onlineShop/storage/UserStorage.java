package homeworks.onlineShop.storage;

import homeworks.onlineShop.enums.UserType;
import homeworks.onlineShop.model.User;
import homeworks.onlineShop.util.StorageSerializeUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserStorage implements Serializable {
    private Map<String, User> users = new HashMap();

    public void print() {
        System.out.println(users);
    }

    public void add(User user) {
        users.put(user.getEmail(), user);
        StorageSerializeUtil.serializeUserStorage(this);
    }

    public User findUserByEmail(String email) {
        return users.get(email);
    }

    public boolean isRegisteredEmail(String email) {
        return users.containsKey(email);
    }

    public boolean isValidPassword(String email, String password) {
        return users.get(email).getPassword().equals(password);
    }

    public void printUsers() {
        for (User user : users.values()) {
            if (user.getType() == UserType.USER) {
                System.out.println(user);
            }
        }
    }
}
