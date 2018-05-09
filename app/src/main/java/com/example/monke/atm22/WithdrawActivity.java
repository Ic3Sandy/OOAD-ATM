package com.example.monke.atm22;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class WithdrawActivity extends AppCompatActivity {

    public Account user_acc;
    DBsqlite mybank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);
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


    public void withDraw(int amount){

        if(user_acc.getBalance() >= amount){

            Bank bank = new Bank();
            int balance = user_acc.getBalance() - amount;
            bank.updateAccount(user_acc.getAccountNumber(), balance, mybank);
            user_acc.setBalance(balance);
            toMenu();

        }

    }

    public void withDraw20(View view){

        withDraw(20);

    }

    public void withDraw40(View view){

        withDraw(40);

    }

    public void withDraw60(View view){

        withDraw(60);

    }

    public void withDraw100(View view){

        withDraw(100);

    }

    public void withDraw300(View view){

        withDraw(300);

    }

    public void withDraw500(View view){

        withDraw(500);

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
