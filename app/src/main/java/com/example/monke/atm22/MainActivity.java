package com.example.monke.atm22;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private EditText acc_num;
    private EditText password;
    DBsqlite mybank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mybank = new DBsqlite(this);

    }

    @Override
    protected void onStart(){

        super.onStart();
        acc_num = (EditText) findViewById(R.id.acc_num);
        password = (EditText) findViewById(R.id.password);

    }

    public void pageMenu(View view) {

        boolean a = TextUtils.isEmpty(acc_num.getText());
        boolean b = TextUtils.isEmpty(password.getText());

        if(a || b){

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }

        else{

            int account = Integer.parseInt(acc_num.getText().toString());
            int pass = Integer.parseInt(password.getText().toString());

            Bank bank = new Bank();
            Account user_acc = bank.checkAccount(account, pass, mybank);

            if(user_acc != null){

                Intent intent = new Intent(this, MenuActivity.class);
                intent.putExtra("Account", (Serializable) user_acc);
                startActivity(intent);

            }

        }

    }
}
