package model;

public class TransactionModel {
    public String from_account;
    public String to_account;
    public double amount;

    public TransactionModel(String from_account, String to_account, double amount) {
        this.from_account = from_account;
        this.to_account = to_account;
        this.amount = amount;
    }
}
