package bank.model;

import bank.model.CheckingAccount;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CheckingAccountRepository{

    CheckingAccount account1 = new CheckingAccount("João da Silva", "54125-9", "10854.78");
    CheckingAccount account2 = new CheckingAccount("Pedro Otávio Magalhães", "25214-8", "1050.99");
    CheckingAccount account3 = new CheckingAccount("Maria Green", "88452-1", "7696.00");
    CheckingAccount account4 = new CheckingAccount("Stephan Pereira", "15935-7", "412.13");

    ArrayList<CheckingAccount> accounts = new ArrayList<>();

    public void makingARepository(){
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
    }

    public CheckingAccount findAccount(String accountNumber){
        makingARepository();
        for (CheckingAccount account: accounts) {
            System.out.println("Conta que está sendo procurada:" + account.getAccountNumber() + " digitada: " + accountNumber);
            System.out.println(account.getAccountNumber().equals(accountNumber));
            if(account.getAccountNumber().equals(accountNumber)){
                System.out.println("O numero da conta encontrada foi:" + account.getAccountNumber());
                return account;
            }
        }
        System.out.println("n deu em nada");
        return null;
    }}
