package bank.view;

import bank.domain.*;

import java.math.BigDecimal;
import java.util.*;

public class ATMTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

            System.out.println("\n\n*** Welcome to ATM v1.0 ***" + "\nPlease, insert your checking account number");
            String checkingAccountNumber = sc.next();
            CheckingAccountRepository.makingARepository();
            CheckingAccount currentCheckingAccount = new CheckingAccountRepository().findAccount(checkingAccountNumber);

            Map<BillType, Integer> bills = new EnumMap<BillType, Integer>(BillType.class);
            bills.put(BillType.TEN_REAIS, 5);
            bills.put(BillType.TWENTY_REAIS, 10);
            bills.put(BillType.FIFTY_REAIS, 5);
            bills.put(BillType.ONE_HUNDRED_REAIS, 5);

            BillDispenser billDispenser = new BillDispenser(bills);

            OneHundredBillDispenserHandler oneHundredBillDispenserHandler = new OneHundredBillDispenserHandler();
            FiftyBillDispenserHandler fiftyBillDispenserHandler = new FiftyBillDispenserHandler();

            oneHundredBillDispenserHandler.setSucessor(fiftyBillDispenserHandler);

            ATM ATM = new ATM();
            ATM.defineAccount(currentCheckingAccount);

            int chosenOption;

        do {

            System.out.println("\nChoose an option, please \n\n1 - Balance " +
                    "\n2 - Withdraw");
            System.out.print("Available bills: ");
            billDispenser.availableBills();
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

                    try {
                        ATM.withdraw(new BigDecimal(amountOfMoney));
                    } catch (InsufficientBalanceException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 3: {System.out.println("What is the destination account's number?");
                    String destinationAccountNumber = sc.next();
                    CheckingAccount destinationCheckingAccount = new CheckingAccountRepository().findAccount(destinationAccountNumber);
             //       ATM.deposit(destinationCheckingAccount);
                    break;
                }

                case 4: {System.out.println("Option #4: Transfer");

                    System.out.println("What is the destination account's number?");
                    String destinationAccountNumber = sc.next();
                    CheckingAccount destinationCheckingAccount = new CheckingAccountRepository().findAccount(destinationAccountNumber);

                    System.out.println("How much do you want to transfer?");
                    String amountOfMoney = sc.next();

                    try {
                        ATM.transfer(destinationCheckingAccount, new BigDecimal(amountOfMoney));
                    } catch (InsufficientBalanceException e) {
                        e.printStackTrace();
                    }

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
