package com.example.monke.atm22;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

public class TransferActivity extends AppCompatActivity {

    public Account user_acc;
    private EditText acc_num;
    private EditText amount;
    DBsqlite mybank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        mybank = new DBsqlite(this);

    }

    @Override
    protected void onStart(){

        super.onStart();
        user_acc = (Account) getIntent().getSerializableExtra("Account");

        // Set account for this page
        TextView textElement = (TextView) findViewById(R.id.account);
        String account = Integer.toString(user_acc.getAccountNumber());
        textElement.setText(account);

        acc_num = (EditText) findViewById(R.id.acc_num);
        amount = (EditText) findViewById(R.id.amount);

    }


    public void toMenu(){

        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("Account", (Serializable) user_acc);
        startActivity(intent);

    }


    public void transferMoney(View view){

        boolean a = TextUtils.isEmpty(acc_num.getText());
        boolean b = TextUtils.isEmpty(amount.getText());

        // Check input exists
        if(a || b){

            Intent intent = new Intent(this, TransferActivity.class);
            startActivity(intent);

        }
        else{

            int acc = Integer.parseInt(acc_num.getText().toString());
            int amo = Integer.parseInt(amount.getText().toString());
            Bank bank = new Bank();

            // Check balance of user and account for transfer exists
            if(user_acc.getBalance() >= amo && bank.checkAccount(acc, mybank)){

                int balance = user_acc.getBalance() - amo;
                bank.updateAccount(user_acc.getAccountNumber(), balance, mybank);
                user_acc.setBalance(balance);

                bank.transfer(acc, amo, mybank);
                toMenu();

            }

        }

    }


    public void pageMenu(View view){

        toMenu();

    }

}
