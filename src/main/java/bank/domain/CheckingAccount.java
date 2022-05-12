package bank.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class CheckingAccount {

    public CheckingAccount(String cardholderName, String accountNumber, String balance){
        this.cardholderName = cardholderName;
        this.accountNumber = accountNumber;
        this.balance = new BigDecimal(balance);
    }

    private final String cardholderName;
    private final String accountNumber;
    private BigDecimal balance;

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal setBalance(BigDecimal value) {
        return this.balance = value;
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
