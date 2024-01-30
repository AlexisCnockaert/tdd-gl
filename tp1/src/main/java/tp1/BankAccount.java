package tp1;

import lombok.Getter;
import lombok.Setter;
import tp1.Exceptions.MoneyLaundryException;
import tp1.Exceptions.NegativeValueException;
import tp1.Exceptions.NullValueException;
import tp1.TransactionHistory.TransactionHistory;

@Getter
@Setter
public class BankAccount {
    private TransactionHistory transactionHistory;
    public static final int SIZE = 10;
    public static final int TOTAL = 0;
    public BankAccount(TransactionHistory transactionHistory){
        this.transactionHistory = transactionHistory;
    }
    public void creditAccount(double amount) throws NegativeValueException, NullValueException, MoneyLaundryException {
        checkForNegativeValue(amount);
        checkForNullValue(amount);
        checkForMoneyLaundring(amount);
        this.transactionHistory.creditAccount(amount);
    }
    public void debitAccount(double amount) throws NegativeValueException, NullValueException, MoneyLaundryException {
        checkForNegativeValue(amount);
        checkForNullValue(amount);
        checkForMoneyLaundring(amount);
        this.transactionHistory.debitAccount(amount);
    }
    public double calculateBalance(){
        return this.transactionHistory.calculateBalance();
    }
    public double retrieveTotalCredited(){
        return this.transactionHistory.retrieveTotalCredited();
    }
    public double retrieveTotalDebited(){
        return this.transactionHistory.retrieveTotalDebited();
    }
    private void checkForNegativeValue(double amount) throws NegativeValueException{
        if(amount < 0){
            throw new NegativeValueException("Negaitve Value");
        }
    }
    private void checkForNullValue(double amount) throws NullValueException{
        if(amount == 0){
            throw new NullValueException("Null Value");
        }
    }
    private void checkForMoneyLaundring(double amount) throws MoneyLaundryException{
        if(amount > 100000){
            throw new MoneyLaundryException("Amount too high");
        }
    }
}
