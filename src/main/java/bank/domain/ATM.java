package bank.domain;

import java.math.BigDecimal;
import java.util.*;

public class ATM {

  //  private final Map<BillType, Integer> bills;
    private Account currentAccount;

  //  public ATM(Map<BillType, Integer> bills) {
  //      this.bills = new EnumMap<>(BillType.class);
   //     this.bills.putAll(bills);
  //  }

    public void defineAccount(Account currentAccount) {

        this.currentAccount = currentAccount;
    }

    public void withdraw(BigDecimal amountOfMoney) throws InsufficientBalanceException {

        currentAccount.removeVirtualMoney(amountOfMoney);
        this.removePhysicalMoney(amountOfMoney);

        // verificar se o valor é suficiente para ser sacado
        // calcular quantas notas de X valor podem ser sacadas
        // verificar se a quantidade de notas de X valor no caixa é suficiente
        // "sacar"
        // atualizar a quantidade de notas de X valor no caixa
        // atualizar o valor do saldo na conta

   //    if (amountOfMoney.compareTo(currentAccount.getBalance()) != 1) {
   //
   //        BigDecimal quotient = amountOfMoney.divide(new BigDecimal(100));
   //
   //        if (quotient.compareTo(BigDecimal.valueOf(bills.get(BillType.ONE_HUNDRED_REAIS))) <= 0) {
   //
   //            int quantidadeDeNotasDe100Sacadas = quotient.intValue();
   //            System.out.println("Here you are: " + quantidadeDeNotasDe100Sacadas + " 100 reais bill(s)");
   //            updateAmountOfBills(BillType.ONE_HUNDRED_REAIS, quotient.negate().intValue());
   //            amountOfMoney = amountOfMoney.subtract(new BigDecimal(quantidadeDeNotasDe100Sacadas * 100));
   //        }
   //
   //        BigDecimal quotientOf50 = amountOfMoney.divide(new BigDecimal(50));
   //
   //        if (quotientOf50.compareTo(BigDecimal.valueOf(bills.get(BillType.FIFTY_REAIS))) <= 0) {
   //
   //            int quantidadeDeNotasDe50Sacadas = quotientOf50.intValue();
   //            System.out.println("Here you are: " + quantidadeDeNotasDe50Sacadas + " 50 reais bill(s)");
   //            updateAmountOfBills(BillType.FIFTY_REAIS, quotientOf50.negate().intValue());
   //            amountOfMoney = amountOfMoney.subtract(new BigDecimal(quantidadeDeNotasDe50Sacadas * 50));
   //
   //        }
   //
   //        BigDecimal quotientOf20 = amountOfMoney.divide(new BigDecimal(20));
   //
   //        if (quotientOf20.compareTo(BigDecimal.valueOf(bills.get(BillType.TWENTY_REAIS))) <= 0) {
   //
   //            int quantidadeDeNotasDe20Sacadas = quotientOf20.intValue();
   //            System.out.println("Here you are: " + quantidadeDeNotasDe20Sacadas + " 20 reais bill(s)");
   //            updateAmountOfBills(BillType.TWENTY_REAIS, quotientOf20.negate().intValue());
   //            amountOfMoney = amountOfMoney.subtract(new BigDecimal(quantidadeDeNotasDe20Sacadas * 20));
   //
   //        }
   //
   //        BigDecimal quotientOf10 = amountOfMoney.divide(new BigDecimal(10));
   //
   //        if (quotientOf10.compareTo(BigDecimal.valueOf(bills.get(BillType.TEN_REAIS))) <= 0) {
   //
   //            int quantidadeDeNotasDe10Sacadas = quotientOf10.intValue();
   //            System.out.println("Here you are: " + quantidadeDeNotasDe10Sacadas + " 10 reais bill(s)");
   //            updateAmountOfBills(BillType.TEN_REAIS, quotientOf10.negate().intValue());
   //            amountOfMoney = amountOfMoney.subtract(new BigDecimal(quantidadeDeNotasDe10Sacadas * 10));
   //
   //        }
   //
        }

    private void removePhysicalMoney(BigDecimal amountOfMoney) {
        OneHundredBillDispenserHandler oneHundredBillDispenserHandler = new OneHundredBillDispenserHandler();
        oneHundredBillDispenserHandler.dispense(amountOfMoney);
    }

    // futuramente isso se tornará uma exceção
   // else System.out.println("Fail: You are trying to withdraw an amount bigger than your balance");

   // }

//   public void deposit(Account destinationAccount){
//
//       BigDecimal totalAmountOfMoney;
//
//       System.out.println("Amount of ten reais bills: ");
//       Integer amountOfBills = getAmountOfBills(BillType.TEN_REAIS);
//       totalAmountOfMoney = conversor(BillType.TEN_REAIS, amountOfBills);
//       updateAmountOfBills(BillType.TEN_REAIS, amountOfBills);
//
//       System.out.println("Amount of twenty reais bills: ");
//       amountOfBills = getAmountOfBills(BillType.TWENTY_REAIS);
//       totalAmountOfMoney = totalAmountOfMoney.add(conversor(BillType.TWENTY_REAIS, amountOfBills));
//       updateAmountOfBills(BillType.TWENTY_REAIS, amountOfBills);
//
//       System.out.println("Amount of fifty reais bills: ");
//       amountOfBills = getAmountOfBills(BillType.FIFTY_REAIS);
//       totalAmountOfMoney = totalAmountOfMoney.add(conversor(BillType.FIFTY_REAIS, amountOfBills));
//       updateAmountOfBills(BillType.FIFTY_REAIS, amountOfBills);
//
//       System.out.println("Amount of one hundred reais bills: ");
//       amountOfBills = getAmountOfBills(BillType.ONE_HUNDRED_REAIS);
//       totalAmountOfMoney = totalAmountOfMoney.add(conversor(BillType.ONE_HUNDRED_REAIS, amountOfBills));
//       updateAmountOfBills(BillType.ONE_HUNDRED_REAIS,amountOfBills);
//
//       destinationAccount.addMoney(totalAmountOfMoney);
//
//   }

    public void transfer(Account destinationAccount, BigDecimal amountOfMoney) throws InsufficientBalanceException {
        currentAccount.removeVirtualMoney(amountOfMoney);
        destinationAccount.addMoney(amountOfMoney);
    }

 //  public void availableBills(){
 //      System.out.print("There are " + bills.get(BillType.TEN_REAIS) + " ten reais bills, " +
 //              bills.get(BillType.TWENTY_REAIS) + " twenty reais bills, " + bills.get(BillType.FIFTY_REAIS)
 //              + " fifty reais bills and " + bills.get(BillType.ONE_HUNDRED_REAIS) + " one hundred reais bills.");
 //   }

    public Integer getAmountOfBills(BillType billType){
        Scanner sc = new Scanner(System.in);
        Integer amountOfBills = Integer.valueOf(sc.next());
        return amountOfBills;
    }

 //   public void updateAmountOfBills(BillType billType, Integer amountOfBills){
 //       Integer newAmountOfBills = bills.get(billType) + amountOfBills;
 //       bills.replace(billType, newAmountOfBills);
 //   }

    public BigDecimal conversor(BillType billType, Integer amountOfBills){
        BigDecimal totalValue = new BigDecimal(amountOfBills);
        BigDecimal newTotalValue = null;

        switch (billType){
            case TEN_REAIS: {
                newTotalValue = totalValue.multiply(new BigDecimal(10));
                break;
            }
            case TWENTY_REAIS:  {
                newTotalValue = totalValue.multiply(new BigDecimal(20));
                break;
            }
            case FIFTY_REAIS: {
                newTotalValue = totalValue.multiply(new BigDecimal(50));
                break;
            }
            case ONE_HUNDRED_REAIS:  {
                newTotalValue = totalValue.multiply(new BigDecimal(100));
                break;
            }
        }
        return newTotalValue;
    }

}
