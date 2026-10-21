import state.Coin;
import state.VendingMachine;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    VendingMachine vendingMachine = VendingMachine.getInstance();

    vendingMachine.addProduct("A1", "Coke", 25, 3);
    vendingMachine.addProduct("A2", "Pepsi", 25, 2);
    vendingMachine.addProduct("B1", "Water", 10, 5);
    vendingMachine.getInventory().displayProducts();


    vendingMachine.selectProduct("A1");
    vendingMachine.insertCoin(Coin.TEN);
    vendingMachine.insertCoin(Coin.FIFTEEN);
    vendingMachine.insertCoin(Coin.FIFTEEN);
    vendingMachine.dispense();

    vendingMachine.selectProduct("A2");
    vendingMachine.insertCoin(Coin.TEN);
    vendingMachine.cancel();






}
