package com.example.monke.atm22;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class DepositActivity extends AppCompatActivity {

    public Account user_acc;
    DBsqlite mybank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);
        mybank = new DBsqlite(this);

    }

    @Override
    protected void onStart(){

        super.onStart();
        user_acc = (Account) getIntent().getSerializableExtra("Account");
        TextView textElement = (TextView) findViewById(R.id.account);
        String account = Integer.toString(user_acc.getAccountNumber());
        textElement.setText(account);

    }

    public void deposit(int amount){

        Bank bank = new Bank();
        int balance = user_acc.getBalance() + amount;
        bank.updateAccount(user_acc.getAccountNumber(), balance, mybank);
        user_acc.setBalance(balance);
        toMenu();

    }


    public void deposit20(View view){

        deposit(20);

    }

    public void deposit40(View view){

        deposit(40);

    }

    public void deposit60(View view){

        deposit(60);

    }

    public void deposit100(View view){

        deposit(100);

    }

    public void deposit300(View view){

        deposit(300);

    }

    public void deposit500(View view){

        deposit(500);

    }


    public void pageMenu(View view){

        toMenu();

    }

    public void toMenu(){

        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("Account", (Serializable) user_acc);
        startActivity(intent);

    }

}
