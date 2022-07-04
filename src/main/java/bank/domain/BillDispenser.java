package bank.domain;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

import static java.util.Collections.unmodifiableMap;

public class BillDispenser {

    private final Map<BillType, Integer> bills;

    public BillDispenser(Map<BillType, Integer> bills) {
        this.bills = new EnumMap<BillType, Integer>(BillType.class);
        this.bills.putAll(bills);
    }

    public Map getBillsMap(){
        return bills;
    }

    public BigDecimal amountOfBillType(BillType billType){
        BigDecimal amountOfBillType = BigDecimal.valueOf(bills.get(billType));
        return amountOfBillType;
    }

    public void availableBills(){
        System.out.print("There are " + bills.get(BillType.TEN_REAIS) + " ten reais bills, " +
                bills.get(BillType.TWENTY_REAIS) + " twenty reais bills, " + bills.get(BillType.FIFTY_REAIS)
                + " fifty reais bills and " + bills.get(BillType.ONE_HUNDRED_REAIS) + " one hundred reais bills.");
     }


}
