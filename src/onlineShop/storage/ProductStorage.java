package onlineShop.storage;

import onlineShop.model.Product;
import onlineShop.util.StorageSerializeUtil;

import java.io.Serializable;

public class ProductStorage implements Serializable {
    private Product[] products = new Product[10];
    private int index = 0;

    private void extend() {
        Product[] temp = new Product[products.length + 10];
        System.arraycopy(products, 0, temp, 0, index);
        products = temp;
        StorageSerializeUtil.serializeProductStorage(this);
    }

    public void print() {
        for (int i = 0; i < index; i++) {
            System.out.println(products[i].toString());
        }
    }


    public Product findProductById(String id) {
        for (int i = 0; i < index; i++) {
            if (products[i].getId().equalsIgnoreCase(id)) {
                return products[i];
            }
        }
        return null;
    }

    public void add(Product product) {
        if (index == products.length) {
            extend();
        }
        products[index++] = product;
        StorageSerializeUtil.serializeProductStorage(this);
    }

    public void removeProductById(String id) {
        for (int i = 0; i < index; i++) {
            if (products[i].getId().equals(id)) {
                removeByIndex(i--);
            }
        }
    }

    private void removeByIndex(int index) {
        for (int i = index; i < this.index; i++) {
            products[i] = products[i + 1];
        }
        this.index--;
        StorageSerializeUtil.serializeProductStorage(this);
    }
}
