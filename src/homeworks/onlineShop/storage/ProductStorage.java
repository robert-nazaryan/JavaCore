package homeworks.onlineShop.storage;

import homeworks.onlineShop.model.Product;
import homeworks.onlineShop.util.StorageSerializeUtil;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ProductStorage implements Serializable {
    private Set<Product> products = new HashSet<>();

    public void print() {
        System.out.println(products);
    }

    public Product findProductById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public void add(Product product) {
        products.add(product);
        StorageSerializeUtil.serializeProductStorage(this);
    }

    public void removeProductById(String id) {
        products.removeIf(product -> product.getId().equals(id));
        StorageSerializeUtil.serializeProductStorage(this);
    }
}
