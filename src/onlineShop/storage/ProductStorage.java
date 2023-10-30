package onlineShop.storage;

import onlineShop.model.Product;

public class ProductStorage {
    private Product[] products = new Product[10];
    private int index = 0;

    private void extend() {
        Product[] temp = new Product[products.length + 10];
        System.arraycopy(products, 0, temp, 0, index);
        products = temp;
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
    }
}
