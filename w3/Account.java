public class Account {
    // instance variables

    private int balance;
    private String name;

    // constructors

    public Account(String initName, int initBalance) {
        name = initName;
        // we count enforce an invariant that an account's balance is nonegative,
        // but I didn't include that in the outline so we won't enforce it
        balance = initBalance;
    }

    // methods

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public boolean transfer(Check check, Account payee) {
        // can't make the transfer if we don't have enough money
        if (check.getAmount() > balance) {
            return false;
        }

        // at this point we know we have enough money, so we can do the whole transfer
        balance -= check.getAmount();
        payee.balance += check.getAmount();
        return true;
    }

    public String format() {
        return String.format("%s: $%d.%02d", name, balance / 100, balance % 100);
    }

}
