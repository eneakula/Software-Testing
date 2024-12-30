import org.example1.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    @Test
    void shouldDeposit(){
        BankAccount account = new BankAccount
                ("Enea", "Kula  ", 1000);

        account.deposit(500);

        Assertions.assertEquals(1500, account.getAmount());

    }

    @Test
    void shouldNotDepositNegativeAmount(){
        BankAccount account = new BankAccount
                ("Enea", "Kula", 1000);

        account.deposit(-500);

        Assertions.assertEquals(1000, account.getAmount());

    }

    @Test
    void shouldWithdraw(){
        BankAccount account = new BankAccount
                ("Ena", "Kula", 1000);
        account.withdraw(500);

        Assertions.assertEquals(500, account.getAmount());
    }

    @Test
    void shouldNotWithdrawWhenNotEnoughFunds(){
        BankAccount account = new BankAccount
                ("Enea", "Kula", 1000);
        account.withdraw(1500);

        Assertions.assertEquals(1000, account.getAmount());
    }


    @Test
    void shouldNotWithdrawWhenNegativeAmount(){
        BankAccount account = new BankAccount
                ("Enea", "Kula", 1000);
        account.withdraw(-100);

        Assertions.assertEquals(1000, account.getAmount());
    }

    @Test
    void shouldTransfer(){
        BankAccount account1 = new BankAccount
                ("Enea", "Kula", 1000);
        BankAccount account2 = new BankAccount
                ("Kristi", "Lico", 0);

        account1.transferTo(account2, 500);

        Assertions.assertEquals(500, account1.getAmount());
        Assertions.assertEquals(500, account2.getAmount());
    }

    @Test
    void shouldNotTransferWhenNotEnoughFunds(){
        BankAccount account1 = new BankAccount
                ("Enea", "Kula", 1000);
        BankAccount account2 = new BankAccount
                ("Kristi", "Lico", 0);

        account1.transferTo(account2, 1500);

        Assertions.assertEquals(1000, account1.getAmount());
        Assertions.assertEquals(0, account2.getAmount());
    }

    @Test
    void shouldNotTransferWhenNegativeAmount(){
        BankAccount account1 = new BankAccount
                ("Enea", "Kula", 1000);
        BankAccount account2 = new BankAccount
                ("Kristi", "Lico", 0);

        account1.transferTo(account2, -1500);

        Assertions.assertEquals(1000, account1.getAmount());
        Assertions.assertEquals(0, account2.getAmount());
    }

}
