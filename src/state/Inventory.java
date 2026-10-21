package state;

import java.util.HashMap;

public class Inventory {
    HashMap<String, Product> productToId = new HashMap<>();
    HashMap<String,Integer> productToQuantiy  = new HashMap<>();

    void addItem(String code , Product product , int quantity){
        productToId.put(code,product);
        productToQuantiy.put(code,quantity);

    }
    public Product getProduct(String code){
        return productToId.get(code);
    }
    boolean isAvailable(String code){
        return productToQuantiy.get(code) > 0;
    }
    void reduceStock(String code){

        if(!isAvailable(code)){
            System.out.println("Product out of stock");
        }
        productToQuantiy.put(code,productToQuantiy.get(code)-1);
    }

    public HashMap<String, Product> getProductToId() {
        return productToId;
    }
    public void displayProducts() {
        for (Product product : productToId.values()) {
            System.out.println(
                    product.getCode() + " - " + product.getName()
                            + " - Price: " + product.getPrice()
                            + " - Stock: " + productToQuantiy.get(product.getCode())
            );
        }
    }
    public void setProductToId(HashMap<String, Product> productToId) {
        this.productToId = productToId;
    }

    public HashMap<String, Integer> getProductToQuantiy() {
        return productToQuantiy;
    }

    public void setProductToQuantiy(HashMap<String, Integer> productToQuantiy) {
        this.productToQuantiy = productToQuantiy;
    }
}
