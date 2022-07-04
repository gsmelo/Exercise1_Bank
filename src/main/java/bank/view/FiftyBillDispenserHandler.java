package bank.view;

import bank.domain.BillDispenserHandler;
import bank.domain.BillType;

import java.math.BigDecimal;

public class FiftyBillDispenserHandler implements BillDispenserHandler {
    @Override
    public void setSucessor(BillDispenserHandler sucessor) {

    }

    @Override
    public void dispense(BigDecimal amountOfMoney) {

    }

    @Override
    public void updateAmountOfBills(BillType billType, Integer amountOfBills) {

    }
}
