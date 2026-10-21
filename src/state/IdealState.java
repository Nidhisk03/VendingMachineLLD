package state;

public class IdealState extends VendingMachineState {
    IdealState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("First select the product.");

    }

    @Override
    public void selectItem(String code) {
        if(!machine.getInventory().isAvailable(code)){
            System.out.println("Product out of stock..");
        }

        machine.setSelectedItems(code);
        System.out.println("Selected: " + machine.getInventory().productToId.get(code).getName());

    machine.setState(new ItemSelecteddState(machine));
    }

    @Override
    public void dispense() {
       System.out.println("No item selected");


    }

    @Override
    public void cancel() {
System.out.println("No active transaction");

    }
}
