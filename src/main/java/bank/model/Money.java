package bank.model;

public class Money {

    private final int amountOf10DollarBill;
    private final int amountOf20DollarBill;
    private final int amountOf50DollarBill;
    private final int amountOf100DollarBill;

    public Money(int amountOf10DollarBill, int amountOf20DollarBill, int amountOf50DollarBill, int amountOf100DollarBill){
        this.amountOf10DollarBill = amountOf10DollarBill;
        this.amountOf20DollarBill = amountOf20DollarBill;
        this.amountOf50DollarBill = amountOf50DollarBill;
        this.amountOf100DollarBill = amountOf100DollarBill;
    }

    // need to think better about this class

    private void totalAmount(){
        int totalAmount = (this.amountOf100DollarBill*100) + (this.amountOf50DollarBill*50) + (this.amountOf20DollarBill*20) + (this.amountOf10DollarBill*10);
    }




}
