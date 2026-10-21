package state;

class CashPayment implements PaymentStrategy {
    @Override
    public boolean pay(int amount) {
        return amount > 0;
    }
}