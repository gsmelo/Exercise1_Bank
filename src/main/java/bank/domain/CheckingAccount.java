package bank.domain;

import javax.naming.InsufficientResourcesException;
import java.math.BigDecimal;
import java.util.Objects;

public class CheckingAccount implements Account {

    public CheckingAccount(String cardholderName, String accountNumber, String balance){
        this.cardholderName = cardholderName;
        this.accountNumber = accountNumber;
        this.balance = new BigDecimal(balance);
    }

    private final String cardholderName;
    private final String accountNumber;
    private BigDecimal balance;

    private void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
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

    @Override
    public BigDecimal getBalance() {
        return this.balance;
    }

    @Override
    public void removeVirtualMoney(BigDecimal amountOfMoney) throws InsufficientBalanceException {
        if(this.getBalance().compareTo(amountOfMoney) > -1){
            this.setBalance(this.balance.subtract(amountOfMoney));
        }
        else throw new InsufficientBalanceException();
    }

    @Override
    public void addMoney(BigDecimal amountOfMoney) {
        this.setBalance(this.balance.add(amountOfMoney));

    }

}
