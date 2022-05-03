package bank.model;

import java.math.BigDecimal;

public class ATM {

    public ATM(Money notasde100, Money notasde50, Money notasde20, Money notasde10){
    }

    public void withdraw(CheckingAccount account, String amountOfMoney){
        //melhorar essa linha
        account.setBalance(account.getBalance().subtract(new BigDecimal(amountOfMoney)));
    }

    public static void deposit(CheckingAccount destinationAccount, String amountOfMoney){
        //melhorar essa linha
        destinationAccount.setBalance(destinationAccount.getBalance().add(new BigDecimal(amountOfMoney)));
    }

    public void transfer(CheckingAccount destinationAccount, CheckingAccount originAccount, String amountOfMoney){
        //melhorar essa linha
        originAccount.setBalance(originAccount.getBalance().subtract(new BigDecimal(amountOfMoney)));
        destinationAccount.setBalance(destinationAccount.getBalance().add(new BigDecimal(amountOfMoney)));
    }

}
