package com.gfg.jbdl.domain;

public class BankAccount {


    /**
     * Data hiding
     *  We restrict the direct access to attribute.
     *
     * */
    private Double balance=0.0;

    public Double getBalance() {
        return balance;
    }

    public void withdarw(Double amount){
        if(amount<0 || amount > balance)
            return;
        this.balance=this.balance-amount;
    }

    public void deposit(Double amount){
        if(amount<0)
            return;
        this.balance=balance+amount;
    }
}
