package com.example.monke.atm22;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

public class ViewBalanceActivity extends AppCompatActivity {

    public Account user_acc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_balance);

    }

    @Override
    protected void onStart(){

        super.onStart();
        user_acc = (Account) getIntent().getSerializableExtra("Account");

        // Set balance for this page
        TextView textElement_balance = (TextView) findViewById(R.id.balance);
        String balance = Integer.toString(user_acc.getBalance());
        textElement_balance.setText(balance);

        // Set account for this page
        TextView textElement_account = (TextView) findViewById(R.id.account);
        String account = Integer.toString(user_acc.getAccountNumber());
        textElement_account.setText(account);


    }


    public void toMenu(){

        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("Account", (Serializable) user_acc);
        startActivity(intent);

    }

    public void pageMenu(View view){

        toMenu();

    }

}
