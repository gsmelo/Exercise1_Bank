package bank.view;

import bank.model.ATM;
import bank.model.CheckingAccount;
import bank.model.CheckingAccountRepository;
import bank.model.Money;

import java.util.Scanner;

public class ATMTest {

    public static void main(String[] args) {

            System.out.println("\n\n*** Welcome to ATM v1.0 ***" + "\nPlease, insert your checking account number");
            Scanner sc = new Scanner(System.in);
            String checkingAccountNumber = sc.next();

            CheckingAccount currentCheckingAccount = new CheckingAccountRepository().findAccount(checkingAccountNumber);
            ATM ATM = new ATM(new Money(5, 100), new Money(5, 50), new Money(5,20), new Money(15,10));
            int chosenOption;

        do {

            System.out.println("\nChoose an option, please \n\n1 - Balance " +
                    "\n2 - Withdraw (available banknotes: " + "inserir notas disponíveis aqui" +
                    "\n3 - Deposit \n4 - Transfer \n5 - Bank Statement \n6 - Exit");
            chosenOption = Integer.parseInt(sc.next());

            switch (chosenOption) {
                case 1: {System.out.println("Option #1: Balance");

                    System.out.println("Your current balance is: R$" + currentCheckingAccount.getBalance());
                    break;
                }

                case 2: {
                    // here I still need to show the available money,
                    // and a final message to tell if the operation was well succeed
                    System.out.println("What amount of money do you want to withdraw?");
                    String amountOfMoney = sc.next();
                    ATM.withdraw(currentCheckingAccount, amountOfMoney);

                    break;
                }
                case 3: {System.out.println("What is the destination account's number?");
                    String destinationAccountNumber = sc.next();
                    CheckingAccount destinationCheckingAccount = new CheckingAccountRepository().findAccount(destinationAccountNumber);

                    System.out.println("How much do you want to deposit?");
                    String amountOfMoney = sc.next();
                    bank.model.ATM.deposit(destinationCheckingAccount, amountOfMoney);

                    break;
                }

                case 4: {System.out.println("Option #4: Transfer");

                    System.out.println("What is the destination account's number?");
                    String destinationAccountNumber = sc.next();
                    CheckingAccount destinationCheckingAccount = new CheckingAccountRepository().findAccount(destinationAccountNumber);

                    System.out.println("How much do you want to transfer?");
                    String amountOfMoney = sc.next();
                    ATM.transfer(destinationCheckingAccount, currentCheckingAccount, amountOfMoney);

                    break;
                }
                case 5: {
                    System.out.println("Option #5: Bank Statement");
                    // here I need to think about the events
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
