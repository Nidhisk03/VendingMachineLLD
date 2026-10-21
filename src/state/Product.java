package state;

public class Product {
    String name;
    String id;
    int price;

    public Product(String name, String code, int price) {
        this.name = name;
        this.id = code;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return id;
    }

    public int getPrice() {
        return price;
    }
}
