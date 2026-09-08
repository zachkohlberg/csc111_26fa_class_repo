public class Check {
    // instance variables

    // final makes this variable immutable (can't reassign it)
    private final int amount;

    // constructors

    public Check(int initAmount) {
        if (initAmount >= 0) {
            amount = initAmount;
        } else {
            amount = 0;
        }
    }

    // methods

    public int getAmount() {
        return amount;
    }

    public String format() {
        return String.format("$%d.%02d", amount / 100, amount % 100);
    }

}
