package bank.model;


import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

// I think this is the Model in MVC

public class CheckingAccount {

    public CheckingAccount(String cardholderName, String accountNumber, BigDecimal balance){
        this.cardholderName = cardholderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public CheckingAccount() { }


    private String cardholderName;
    private String accountNumber;
    private BigDecimal balance;

    // @Requires("balance > withdrawalAmount")
    public void withdraw(BigDecimal withdrawalAmount){
        balance = balance.subtract(withdrawalAmount);
    }

    public static void deposit(BigDecimal amount, CheckingAccount destinationAccount){
        destinationAccount.balance = destinationAccount.getBalance().add(amount);
    }

    public void transfer(BigDecimal amount, CheckingAccount destinationAccount, CheckingAccount originAccount){
        originAccount.balance = originAccount.balance.subtract(amount);
        destinationAccount.balance = destinationAccount.balance.add(amount);
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CheckingAccount)) return false;
        CheckingAccount that = (CheckingAccount) o;
        return Objects.equals(accountNumber, that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}
