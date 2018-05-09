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
        TextView textElement1 = (TextView) findViewById(R.id.account);
        TextView textElement2 = (TextView) findViewById(R.id.balance);
        String account = Integer.toString(user_acc.getAccountNumber());
        String balance = Integer.toString(user_acc.getBalance());
        textElement1.setText(account);
        textElement2.setText(balance);

    }

    public void pageMenu(View view){

        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("Account", (Serializable) user_acc);
        startActivity(intent);

    }

}
