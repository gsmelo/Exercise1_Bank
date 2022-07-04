package bank.domain;

@FunctionalInterface
public interface BillCalculator<BigDecimal, Map>{

    void calculate(BigDecimal amountOfMoney, Map bills);
}