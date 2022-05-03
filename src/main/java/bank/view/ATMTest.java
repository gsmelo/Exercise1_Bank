package bank.view;

import bank.model.CheckingAccount;
import bank.model.CheckingAccountRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

// I think this is the View in the MVC pattern

public class ATMTest {

    public static void main(String[] args) {


            Scanner sc = new Scanner(System.in);

            System.out.println("*** Welcome to ATM v1.0 ***");
            System.out.println("Please, insert your checking account number");

            String checkingAccountNumber = sc.next();

            CheckingAccount currentCheckingAccount = new CheckingAccountRepository().findAccount(checkingAccountNumber);

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
                    CheckingAccount destinationCheckingAccount = new CheckingAccountRepository().findAccount(destinationAccountNumber);

                    System.out.println("How much do you want to deposit?");

                    String amountOfMoney = sc.next();
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

        } while(chosenOption != 6);




    }
}
