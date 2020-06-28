package in.ag15;

public class TransactionInfo implements Cloneable {
    String to, from;
    double amount;

    @Override
    public Object clone() throws CloneNotSupportedException {
        super.clone();  //Q. Read about what this call does?
        return new TransactionInfo(to, from, amount);
    }

    public TransactionInfo(String to, String from, double amount) {
        this.to = to;
        this.from = from;
        this.amount = amount;
    }
}
