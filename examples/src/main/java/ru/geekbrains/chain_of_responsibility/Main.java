package ru.geekbrains.chain_of_responsibility;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank(100);
        Paypal paypal = new Paypal(200);
        Bitcoin bitcoin = new Bitcoin(300);
        bank.setNext(paypal);
        paypal.setNext(bitcoin);
        bank.pay(259);
    }
}
