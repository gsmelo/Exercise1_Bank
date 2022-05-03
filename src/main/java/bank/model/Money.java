package bank.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Money {

    public Money(int quantidade, int valor){
        this.quantidade = quantidade;
        this.valor = new BigDecimal(valor);
        totalMoney.add(this);
    }

    private final int quantidade;
    private final BigDecimal valor;
    List<Money> totalMoney = new ArrayList<>();

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void availableMoney(){
        System.out.println("The banknotes available are:");
        for (Money money: totalMoney
             ) {
            System.out.println("\nR$" + money.getValor() + "banknotes");
        }
    }












    //Money notade100 = new Money(5, 100);
    //Money notade50 = new Money(5, 50);
    //Money notade20 = new Money(5, 20);
    //Money notade10 = new Money(15, 10);

//    public void something(){
//
//        List<Money> totalMoney = new ArrayList<>();
//        totalMoney.add(notade100);
//        totalMoney.add(notade50);
//        totalMoney.add(notade20);
//        totalMoney.add(notade10);
//
//    }
//




}
