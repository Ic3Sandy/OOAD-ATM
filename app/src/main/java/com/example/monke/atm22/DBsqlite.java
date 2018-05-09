package com.example.monke.atm22;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBsqlite extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBsqlite.db";

    public DBsqlite(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql= "create table users (id integer primary key, acc_num integer, password integer, balance text)";
        db.execSQL(sql);
        sql = "insert into users (acc_num, password, balance) values (123, 123, 500), (456, 123, 400), (789, 123, 300)";
        db.execSQL(sql);
    }


    public boolean insertUsers(int acc_num, int password, int balance){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("acc_num", acc_num);
        contentValues.put("password", password);
        contentValues.put("balance", balance);
        db.insert("users", null, contentValues);
        return true;

    }

    public boolean updateUsers(int acc_num, int balance){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("balance", balance);
        db.update("users", contentValues, "acc_num = ?", new String[] {Integer.toString(acc_num)});
        return true;

    }

    public Integer deleteUsers(Integer acc_num){

        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("users", "acc_num = ?", new String[] {Integer.toString(acc_num)});

    }

    public Cursor getUsers(int acc_num){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from users where acc_num="+acc_num+"", null );
        return res;

    }



}
