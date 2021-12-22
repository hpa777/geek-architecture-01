package ru.geekbrains.chain_of_responsibility;

public abstract class Account {

    protected Account successor;

    public void setNext(Account account) {
        this.successor = account;
    }

    protected int balance;

    public boolean canPay(int amount) {
        return this.balance >= amount;
    }

    public void pay(int amountToPay) {
        if (canPay(amountToPay)) {
            System.out.printf("Paid %d using %s%n", amountToPay, this.getClass().getSimpleName());
        } else if (this.successor != null) {
            System.out.printf("Cannot pay using %s. Proceeding ..%n",  this.getClass().getSimpleName());
            this.successor.pay(amountToPay);
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
