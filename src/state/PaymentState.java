package state;

import java.util.ArrayList;

public class PaymentState extends VendingMachineState {
    public PaymentState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin(Coin coin) {
        if (coin.getVal() <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }

        machine.addBalance(coin.getVal());
        System.out.println("Balance: " + machine.getBalance());
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Can't select item while doing payment");
    }

    @Override
    public void dispense() {
      Product product = machine.getInventory().productToId.get(machine.getSelectedItems());
      if(machine.getBalance()<product.getPrice()){
          System.out.println("Insufficient funds");
      }

      if(!machine.getInventory().isAvailable(machine.getSelectedItems())){
          machine.cancelAndRefund();
          System.out.println("Product out of stock");
      }

      machine.setState(new DispensingState(machine));
      machine.dispenseSelectedProduct();

    }

    @Override
    public void cancel() {
        machine.cancelAndRefund();
    }
}
