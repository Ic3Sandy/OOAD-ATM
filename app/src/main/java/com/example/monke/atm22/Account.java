package com.example.monke.atm22;

import java.io.Serializable;

public class Account implements Serializable {

    private int account;
    private int balance;

    public Account(int account_num){

        setAccountNumber(account_num);

    }


    private void setAccountNumber(int account){

        this.account = account;

    }
    public int getAccountNumber(){

        return account;

    }

    public void setBalance(int balance){

        this.balance = balance;

    }
    public int getBalance(){

        return balance;

    }

}
