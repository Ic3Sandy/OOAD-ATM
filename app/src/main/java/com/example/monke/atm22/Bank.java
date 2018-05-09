package com.example.monke.atm22;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;

public class Bank extends AppCompatActivity {


    public Account checkAccount(int account, int password, DBsqlite mydb){

        Cursor res = mydb.getUsers(account);

        if(res.getCount() == 0){

            res.close();
            return null;

        }

        else{

            res.moveToFirst();
            int check_password = res.getInt(res.getColumnIndex("password"));

            if(check_password != password){

                res.close();
                return null;

            }
            else{

                Account user_acc = new Account(account);
                user_acc.setBalance(res.getInt(res.getColumnIndex("balance")));
                res.close();
                return user_acc;

            }

        }

    }


    public void updateAccount(int account, int amount, DBsqlite mydb){

        mydb.updateUsers(account, amount);

    }

}
