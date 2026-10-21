package state;

import java.util.ArrayList;

public class DispensingState extends VendingMachineState {
    public DispensingState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Dispensing in progress");
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Dispensing in progress");
    }

    @Override
    public void dispense() {
        System.out.println("Already dispensing");
    }

    @Override
    public void cancel() {
       System.out.println("Cannot cancel during dispensing\"");
    }
}
