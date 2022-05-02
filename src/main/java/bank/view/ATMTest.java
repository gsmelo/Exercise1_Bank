package bank.view;

import bank.model.CheckingAccount;
import bank.model.CheckingAccountRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

// I think this is the View in the MVC pattern

public class ATMTest {

    CheckingAccount account1 = new CheckingAccount("João da Silva", "54125-9", new BigDecimal("10854.78"));
    CheckingAccount account2 = new CheckingAccount("Pedro Otávio Magalhães", "25214-8", new BigDecimal("1050.99"));
    CheckingAccount account3 = new CheckingAccount("Maria Green", "88452-1", new BigDecimal("7696.00"));
    CheckingAccount account4 = new CheckingAccount("Stephan Pereira", "15935-7", new BigDecimal("412.13"));

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
    }


    public static void main(String[] args) {


            Scanner sc = new Scanner(System.in);

            System.out.println("*** Welcome to ATM v1.0 ***");
            System.out.println("Please, insert your checking account number");

            String checkingAccountNumber = sc.next();

            CheckingAccount currentCheckingAccount = new ATMTest().findAccount(checkingAccountNumber);

            // validar numero da conta corrente

            int chosenOption;

        do {

            System.out.println("Choose an option, please \n\n1 - Balance");
            System.out.println("2 - Withdraw (available banknotes: " + "inserir notas disponíveis aqui");
            System.out.println("3 - Deposit \n4 - Transfer \n5 - Bank Statement \n6 - Exit");

            chosenOption = Integer.parseInt(sc.next());

            switch (chosenOption) {
                // PAY ATTENTION HERE, NEED TO FIX IT
                case 1: System.out.println("Vc escolheu a opção 1");
                case 2: System.out.println("Vc escolheu a opção 2");
                case 3: {System.out.println("What is the destination account's number?");
                    String destinationAccountNumber = sc.next();

                    //melhorar essa linha
                    CheckingAccount destinationCheckingAccount = new ATMTest().findAccount(destinationAccountNumber);

                    System.out.println("How much do you want to deposit?");
                    String amountOfMoney = sc.next();

                    //melhorar essa linha
                    CheckingAccount.deposit(new BigDecimal(amountOfMoney), destinationCheckingAccount);
                    System.out.println(destinationCheckingAccount.getBalance());
                    break;
                }

                case 4: {
                    System.out.println("Vc escolheu a opção 4");
                    break;
                }
                case 5: {
                    System.out.println("Vc escolheu a opção 5");
                    break;
                }
                case 6: {
                    System.out.println("Thank you! Good bye!");
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + chosenOption);
            }

            CheckingAccount account1 = new CheckingAccount("João da Silva", "54125-9", new BigDecimal("10500"));
            account1.withdraw(new BigDecimal("15000"));

        } while(chosenOption != 6);




    }
}
