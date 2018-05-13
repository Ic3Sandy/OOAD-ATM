package com.example.monke.atm22;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class MenuActivity extends AppCompatActivity {

    public Account user_acc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    @Override
    protected void onStart(){

        super.onStart();
        user_acc = (Account) getIntent().getSerializableExtra("Account");

        // Set account for this page
        TextView textElement = (TextView) findViewById(R.id.account);
        String account = Integer.toString(user_acc.getAccountNumber());
        textElement.setText(account);

    }


    public void startNext(Intent intent){

        intent.putExtra("Account", (Serializable) user_acc);
        startActivity(intent);

    }


    public void pageViewBalance(View view){

        startNext(new Intent(this, ViewBalanceActivity.class));

    }


    public void pageTransfer(View view){

        startNext(new Intent(this, TransferActivity.class));

    }


    public void pageWithdraw(View view){

        startNext(new Intent(this, WithdrawActivity.class));

    }


    public void pageDeposit(View view){

        startNext(new Intent(this, DepositActivity.class));

    }


    public void pageMain(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}
