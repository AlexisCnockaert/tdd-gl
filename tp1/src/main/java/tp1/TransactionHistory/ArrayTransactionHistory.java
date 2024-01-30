package tp1.TransactionHistory;

import lombok.Getter;
import lombok.Setter;
import tp1.BankAccount;

@Getter
@Setter
public class ArrayTransactionHistory extends TransactionHistory{
    public ArrayTransactionHistory(){
        this.creditHistory = new double[BankAccount.SIZE];
        this.debitHistory = new double[BankAccount.SIZE];
        this.debitIndex = 1;
        this.creditIndex = 1;
        this.creditHistory[BankAccount.TOTAL] = 0;
        this.debitHistory[BankAccount.TOTAL] = 0;
    }
    public void resetCreditHistory(){
        for (int i = 1; i < this.creditIndex; i++) {
            creditHistory[BankAccount.TOTAL]+=creditHistory[i];
            creditHistory[i] = 0;
        }
        this.creditIndex = 1;
    }
    public void resetDebitHistory(){
        for (int i = 1; i < this.debitIndex; i++) {
            debitHistory[BankAccount.TOTAL]+=debitHistory[i];
            debitHistory[i] = 0;
        }
        this.debitIndex = 1;
    }
    public void creditAccount(double amount){
        if(creditIndex == BankAccount.SIZE){
            this.resetCreditHistory();
        }
        this.creditHistory[creditIndex] = amount;
        creditIndex++;
    }
    public void debitAccount(double amount){
        if(debitIndex == BankAccount.SIZE){
            this.resetDebitHistory();
        }
        this.debitHistory[debitIndex] = amount;
        debitIndex++;
    }
    public double retrieveTotalCredited(){
        resetCreditHistory();
        return this.creditHistory[BankAccount.TOTAL];
    }
    public double retrieveTotalDebited(){
        resetDebitHistory();
        return this.debitHistory[BankAccount.TOTAL];
    }

}
