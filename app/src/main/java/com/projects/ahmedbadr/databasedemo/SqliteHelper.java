package com.projects.ahmedbadr.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Ahmed Badr for DataBaseDemo on 2/4/2016.
 */
 class DataBase{
    Context context;
    private SQLiteDatabase db;
    public static final String TABLE_NAME = "user";
    public static final String FIRSTNAME = "firt_name";
    public static final String LASTNAME = "last_name";
    public static final String EMAIL= "email";

    public DataBase(Context context)
    {
        this.context = context;
        SqliteHelper helper = new SqliteHelper(context);
        db = helper.getWritableDatabase();
    }

    public void addUser(String column1, String column2,String column3)
    {
        ContentValues values = new ContentValues();
        values.put(FIRSTNAME, column1);
        values.put(LASTNAME, column2);
        values.put(EMAIL, column3);

        // ask the database object to insert the new data
        try{db.insert(TABLE_NAME, null, values);}
        catch(Exception e)
        {
            Log.e("DB ERROR", e.toString());
            e.printStackTrace();
        }
    }
}
public class SqliteHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "user";
    public static final String ID = "id";
    public static final String FIRSTNAME = "firt_name";
    public static final String LASTNAME = "last_name";
    public static final String EMAIL= "email";
    public static final String DATABASE_NAME= "databse";
    public static final int DATABASE_VERSION= 1;


    public SqliteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                ID + " integer primary key autoincrement not null," +
                FIRSTNAME + " TEXT NOT NULL," +
                LASTNAME + " TEXT  NOT NULL, " +
                EMAIL + " TEXT NOT NULL " +
                " );";
        db.execSQL(SQL_CREATE_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}


