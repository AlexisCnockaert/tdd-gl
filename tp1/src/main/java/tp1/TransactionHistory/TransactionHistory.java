package tp1.TransactionHistory;

public abstract class TransactionHistory {
    protected double[] creditHistory;
    protected double[] debitHistory;
    protected int creditIndex;
    protected int debitIndex;
    public double calculateBalance(){
        return retrieveTotalCredited() - retrieveTotalDebited();
    }
    public abstract void resetCreditHistory();
    public abstract void resetDebitHistory();
    public abstract void debitAccount(double amount);
    public abstract void creditAccount(double amount);
    public abstract double retrieveTotalDebited();
    public abstract double retrieveTotalCredited();
}
