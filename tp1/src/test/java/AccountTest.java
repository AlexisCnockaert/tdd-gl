import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp1.BankAccount;
import tp1.Exceptions.MoneyLaundryException;
import tp1.Exceptions.NegativeValueException;
import tp1.Exceptions.NullValueException;
import tp1.TransactionHistory.ArrayTransactionHistory;
import tp1.TransactionHistory.TransactionHistory;


public class AccountTest {
    private BankAccount myAccount;
    @BeforeEach
    public void init(){
        this.myAccount = new BankAccount(new ArrayTransactionHistory());
    }

    @Test
    public void initTest(){
        assertEquals(0, this.myAccount.retrieveTotalCredited());
        assertEquals(0, this.myAccount.retrieveTotalDebited());
    }
    @Test
    public void whenAccountCreditedIncrementCreditAccountByGivenValue() throws NegativeValueException, NullValueException, MoneyLaundryException{
        this.myAccount.creditAccount(500);
        assertEquals(500, this.myAccount.retrieveTotalCredited());
    }

    @Test
    public void whenAccountthIncrementDebitAccountByGivenValue() throws NegativeValueException, NullValueException, MoneyLaundryException{
        this.myAccount.debitAccount(600);
        assertEquals(600, this.myAccount.retrieveTotalDebited());
    }
    
    @Test
    public void whenCreditAmountisNegtivethenThrowException(){
        assertThrows(NegativeValueException.class, ()->{
            this.myAccount.creditAccount(-600);
        });
    }
    @Test
    public void whenDebitAmountisNegtivethenThrowException(){
        assertThrows(NegativeValueException.class, ()->{
            this.myAccount.debitAccount(-600);
        });
    }

    @Test
    public void creditingAndDebitingWorkSeamlessly() throws NegativeValueException, NullValueException, MoneyLaundryException{
        myAccount.creditAccount(10);
        assertEquals(10, myAccount.calculateBalance());
        myAccount.creditAccount(60);
        assertEquals(70, myAccount.calculateBalance());
        myAccount.debitAccount(30);
        assertEquals(40, myAccount.calculateBalance());
        myAccount.debitAccount(10);
        assertEquals(30, myAccount.calculateBalance());
    }

    @Test
    public void whenCreditHistoryFullThenResetCreditHistory() throws NegativeValueException, NullValueException, MoneyLaundryException{
        assertEquals(0, myAccount.retrieveTotalCredited());
        for (int i = 0; i < BankAccount.SIZE-1; i++) {
            myAccount.creditAccount(10);
        }
        assertEquals(90, myAccount.retrieveTotalCredited());
    }

    @Test
    public void whenCreditedAmountisNullThenThrowException(){
        assertThrows(NullValueException.class, () ->{
            myAccount.creditAccount(0);
        });
    }

    @Test
    public void whenDebitedAmountisNullThenThrowException(){
        assertThrows(NullValueException.class, () ->{
            myAccount.debitAccount(0);
        });
    }

    @Test
    public void whenCreditedAmountTooHighNThenThrowException(){
        assertThrows(MoneyLaundryException.class, () ->{
            myAccount.creditAccount(1000000);
        });
    }
    
    @Test
    public void whenDebitedAmountTooHighNThenThrowException(){
        assertThrows(MoneyLaundryException.class, () ->{
            myAccount.debitAccount(1000000);
        });
    }
    
    public class TransactionHistoryMock implements TransactionHistory{
        public int verifyMethodCall = 0;
        public double calculateBalance(){

        }
        public void resetCreditHistory(){

        }
        public void resetDebitHistory(){

        }
        public void debitAccount(double amount){

        }
        public void creditAccount(double amount){

        }
        public double retrieveTotalDebited(){
            
        }
        public double retrieveTotalCredited(){

        }
    }
}   
