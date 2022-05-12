package bank.domain;

import java.math.BigDecimal;
import java.util.*;


public class ATM {

    private final Map<BillType, Integer> bills;
    private CheckingAccount currentAccount;

    public ATM(Map<BillType, Integer> bills) {
        this.bills = new EnumMap<>(BillType.class);
        this.bills.putAll(bills);
    }

    // não pedir uma conta para cada metodo, considerar que o usuário fez "login" na ATM
    // e agora todos os métodos serão direcionados a esta conta

    public void withdraw(String amountOfMoney){
        currentAccount.setBalance(currentAccount.getBalance().subtract(new BigDecimal(amountOfMoney)));
    }

    public static void deposit(CheckingAccount destinationAccount, String amountOfMoney){
        //melhorar essa linha
        destinationAccount.setBalance(destinationAccount.getBalance().add(new BigDecimal(amountOfMoney)));
    }

    public void transfer(CheckingAccount destinationAccount, String amountOfMoney){
        //melhorar essa linha
        currentAccount.setBalance(currentAccount.getBalance().subtract(new BigDecimal(amountOfMoney)));
        destinationAccount.setBalance(destinationAccount.getBalance().add(new BigDecimal(amountOfMoney)));
    }

    public void availableBills(){
        //preciso melhorar para que tudo seja impresso na tela de maneira padronizada e legivel, mas ainda não sei como
        System.out.print(Collections.singletonList(bills));
    }

}
