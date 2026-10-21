package state;

import java.util.ArrayList;

public class ItemSelecteddState extends VendingMachineState {

    ItemSelecteddState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin(Coin coin) {
        if(coin.getVal()<0){
            System.out.println("Invalid amount");
        }
        machine.addBalance(coin.getVal());
        machine.setState(new PaymentState( machine));
        System.out.println("Inserted: " + coin.getVal());
        System.out.println("Balance: " + machine.getBalance());

    }

    @Override
    public void selectItem(String code) {
      System.out.println("Item already selected");
    }

    @Override
    public void dispense() {
        System.out.println("Insert payment first");
    }

    @Override
    public void cancel() {
        machine.resetTransaction();
        machine.setState(new IdealState(machine));
        System.out.println("Transaction cancelled");
    }
}
