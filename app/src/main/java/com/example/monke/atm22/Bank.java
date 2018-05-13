package com.example.monke.atm22;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;

public class Bank extends AppCompatActivity {

    // Check account exists and return boolean
    public boolean checkAccount(int account, DBsqlite mydb){

        Cursor res = mydb.getUsers(account);

        if(res.getCount() == 0) {

            res.close();
            return false;

        }else {

            res.close();
            return true;

        }

    }

    // Check account exists and return object Account
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


    // Update balance for account
    public void updateAccount(int account, int amount, DBsqlite mydb){

        mydb.updateUsers(account, amount);

    }


    // Transfer amount to account
    public void transfer(int account, int amount, DBsqlite mydb){

        Cursor res = mydb.getUsers(account);
        res.moveToFirst();
        int balance = res.getInt(res.getColumnIndex("balance")) + amount;
        mydb.updateUsers(account, balance);
        res.close();

    }

}
