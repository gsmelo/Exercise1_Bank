package bank.domain;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

public interface BillDispenserHandler {

    BillDispenserHandler sucessor = null;

    void setSucessor(BillDispenserHandler sucessor);

    void dispense(BigDecimal amountOfMoney);

    void updateAmountOfBills(BillType billType, Integer amountOfBills);
}
