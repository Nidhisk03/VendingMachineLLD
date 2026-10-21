package state;

public enum Coin {
    ONE(1)
    ,FIVE(5),TEN(10),FIFTEEN(15);

    int val;
    Coin (int val){
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
