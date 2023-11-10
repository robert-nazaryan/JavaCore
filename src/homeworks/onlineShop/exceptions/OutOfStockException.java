package homeworks.onlineShop.exceptions;

public class OutOfStockException extends Exception {
    @Override
    public String toString() {
        return "This quantity is not in stock";
    }
}
