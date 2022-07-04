package bank.domain;

import java.math.BigDecimal;

public interface Account {

    BigDecimal getBalance();

    void removeVirtualMoney(BigDecimal amountOfMoney) throws InsufficientBalanceException;

    void addMoney(BigDecimal amountOfMoney);

}
