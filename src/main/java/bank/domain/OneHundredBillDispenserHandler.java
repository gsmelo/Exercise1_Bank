package bank.domain;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

public class OneHundredBillDispenserHandler implements BillDispenserHandler {

    private BillDispenserHandler sucessor;
    Map<BillType, Integer> bills = new EnumMap<BillType, Integer>(BillType.class);
    private final BillDispenser billDispenser = new BillDispenser(bills);

    @Override
    public void setSucessor(BillDispenserHandler sucessor) {
        this.sucessor= sucessor;
    }

    public void dispense(BigDecimal amountOfMoney) {

        BigDecimal quotient = amountOfMoney.divide(new BigDecimal(100));
        if (quotient.compareTo((BigDecimal) billDispenser.getBillsMap().get(BillType.ONE_HUNDRED_REAIS)) <= 0) {

            int quantidadeDeNotasDe100Sacadas = quotient.intValue();
            System.out.println("Here you are: " + quantidadeDeNotasDe100Sacadas + " 100 reais bill(s)");
            updateAmountOfBills(BillType.ONE_HUNDRED_REAIS, quotient.negate().intValue());
            amountOfMoney = amountOfMoney.subtract(new BigDecimal(quantidadeDeNotasDe100Sacadas * 100));
        }
        sucessor.dispense(amountOfMoney);
    }

    @Override
    public void updateAmountOfBills(BillType billType, Integer amountOfBills) {
        this.billDispenser.getBillsMap().replace(billType, amountOfBills);
        System.out.println("billtype: " + billType + " / amount: " + amountOfBills);
    }

}
