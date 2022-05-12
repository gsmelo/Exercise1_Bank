package bank.view;

import bank.db.DB;
import bank.domain.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.util.*;

public class ATMTest {

    public static void main(String[] args) {

        Connection conn = DB.getConnection();
        DB.closeConnection();

            System.out.println("\n\n*** Welcome to ATM v1.0 ***" + "\nPlease, insert your checking account number");
            Scanner sc = new Scanner(System.in);
            String checkingAccountNumber = sc.next();

            Map<BillType, Integer> billsMap = new HashMap<BillType, Integer>();

            billsMap.put(BillType.TEN_REAIS, 5);
            billsMap.put(BillType.TWENTY_REAIS, 10);
            billsMap.put(BillType.FIFTY_REAIS, 5);
            billsMap.put(BillType.ONE_HUNDRED_REAIS, 5);

            ATM ATM = new ATM(billsMap);
            CheckingAccount currentCheckingAccount = new CheckingAccountRepository().findAccount(checkingAccountNumber);
            int chosenOption;

        do {

            System.out.println("\nChoose an option, please \n\n1 - Balance " +
                    "\n2 - Withdraw");
            System.out.println("The available bills are: ");
            ATM.availableBills();
            System.out.println("\n3 - Deposit \n4 - Transfer \n5 - Bank Statement \n6 - Exit");
            chosenOption = Integer.parseInt(sc.next());

            switch (chosenOption) {
                case 1: {System.out.println("Option #1: Balance");

                    System.out.println("Your current balance is: R$" + currentCheckingAccount.getBalance());
                    break;
                }

                case 2: {
                    System.out.println("What amount of money do you want to withdraw?");
                    String amountOfMoney = sc.next();
                    ATM.withdraw(amountOfMoney);

                    break;
                }
                case 3: {System.out.println("What is the destination account's number?");
                    String destinationAccountNumber = sc.next();
                    CheckingAccount destinationCheckingAccount = new CheckingAccountRepository().findAccount(destinationAccountNumber);

                    System.out.println("How much do you want to deposit?");
                    String amountOfMoney = sc.next();
                    bank.domain.ATM.deposit(destinationCheckingAccount, amountOfMoney);

                    break;
                }

                case 4: {System.out.println("Option #4: Transfer");

                    System.out.println("What is the destination account's number?");
                    String destinationAccountNumber = sc.next();
                    CheckingAccount destinationCheckingAccount = new CheckingAccountRepository().findAccount(destinationAccountNumber);

                    System.out.println("How much do you want to transfer?");
                    String amountOfMoney = sc.next();
                 //   ATM.transfer(destinationCheckingAccount, amountOfMoney);

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
