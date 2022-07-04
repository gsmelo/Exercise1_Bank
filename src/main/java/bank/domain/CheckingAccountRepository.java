package bank.domain;

import java.util.ArrayList;
import java.util.List;

public class CheckingAccountRepository{

    static CheckingAccount account1 = new CheckingAccount("João da Silva", "54125-9", "10854.78");
    static CheckingAccount account2 = new CheckingAccount("Pedro Otávio Magalhães", "25214-8", "1050.99");
    static CheckingAccount account3 = new CheckingAccount("Maria Green", "88452-1", "7696.00");
    static CheckingAccount account4 = new CheckingAccount("Stephan Pereira", "15935-7", "412.13");

    private static final List<CheckingAccount> accounts = new ArrayList<>();

    public static void makingARepository(){
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
    }

    public CheckingAccount findAccount(String accountNumber){
        for (CheckingAccount account: accounts) {
            if(account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        return null;
    }}
