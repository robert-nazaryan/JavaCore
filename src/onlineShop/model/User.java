package onlineShop.model;

import onlineShop.enums.UserType;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class User implements Serializable {
    private String id;
    private String name;
    private String email;
    private String password;
    private UserType type;

    public User(String name, String email, String password, String type) {
        id = UUID.randomUUID().toString().substring(0, 5);
        this.name = name;
        this.email = email;
        this.password = password;
        if (type.equals("0")) {
            this.type = UserType.ADMIN;
        } else {
            this.type = UserType.USER;
        }
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

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
