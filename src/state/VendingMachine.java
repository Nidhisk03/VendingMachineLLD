package state;

import java.util.ArrayList;

public class VendingMachine {
    public static VendingMachine instance = new VendingMachine();

    VendingMachineState state;
    Inventory inventory = new Inventory();
    String selectedItems;
    int balance= 0;


    private VendingMachine(){
        state = new IdealState(this);
    }
    public static VendingMachine getInstance()
    {
        return instance;
    }
    public void setSelectedItems(String selectedItems) {
        this.selectedItems = selectedItems;
    }

    public void insertCoin(Coin coin){
           state.insertCoin(coin);
    }

    public Product addProduct(String code, String name , int price,int quantity){
        Product product = new Product(name,code,price);
        inventory.addItem(code,product,quantity);
        return product;
    }

    public void selectProduct(String code){
        state.selectItem(code);
    }

    public void dispense(){
        state.dispense();
    }
    public void setState(VendingMachineState vendingMachineState){
        this.state = vendingMachineState;
    }

    public VendingMachineState getState() {
        return state;
    }
public void cancel(){
        state.cancel();
}
    public void addBalance(int balance){
       this.balance+=balance;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getSelectedItems() {
        return selectedItems;
    }

    public int getBalance() {
        return balance;
    }
    void cancelAndRefund() {
        System.out.println("Refund returned: " + balance);
        resetTransaction();
        state = new IdealState(this);
    }

    void resetTransaction() {
        balance = 0;
        selectedItems = null;
    }
    void dispenseSelectedProduct() {
        Product product = inventory.productToId.get(selectedItems);

        // Check stock before committing the transaction.
        inventory.reduceStock(product.getCode());

        int change = balance - product.getPrice();

        System.out.println("Dispensing: " + product.getName());
        System.out.println("Change returned: " + change);

        resetTransaction();
        state = new IdealState(this);
    }
}
