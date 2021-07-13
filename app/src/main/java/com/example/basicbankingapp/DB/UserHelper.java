package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(6660,'Santhosh', 'santhu@gmail.com','5847','9564123878', 12000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8625,'Googly', 'googly@gmail.com','2581','9564123889', 3300)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Kaustub', 'kaustub@gmail.com','8968','8645896104', 2200)");
        db.execSQL("insert into " + TABLE_NAME + " values(2581,'Shridhar', 'shridhar@gmail.com','5277','7640038999', 7800)");
        db.execSQL("insert into " + TABLE_NAME + " values(4107,'Sanjay', 'sanjay@gmail.com','6693','9064896295', 5700)");
        db.execSQL("insert into " + TABLE_NAME + " values(5298,'Kumara', 'kumara@gmail.com','8599','8556402388', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Rocky', 'rocky@gmail.com','2071','8956402158', 5400)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Preetham', 'preetham@gmail.com','5224','8502153998', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(6245,'Shruthi', 'sruthi@gmail.com','8256','9652388097', 24500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3652,'Rohini', 'rohini@gmail.com','4505','9259120182', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(8574,'Rashmi', 'rashmi@gmail.com','6562','8015641200', 8910)");
        db.execSQL("insert into " + TABLE_NAME + " values(6213,'Ritish', 'ritish@gmail.com','1032','8185641999', 12000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1221,'Mahendra', 'mahendra@gmail.com','5665','7919541001', 6800)");
        db.execSQL("insert into " + TABLE_NAME + " values(5129,'Rahul', 'rahul@gmail.com','2362','7254642205', 3300)");
        db.execSQL("insert into " + TABLE_NAME + " values(5307,'Abdul', 'abdul@gmail.com','6926','6936412666', 1110)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}