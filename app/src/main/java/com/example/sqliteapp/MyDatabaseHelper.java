package com.example.sqliteapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

class MyDataBaseHelper extends SQLiteOpenHelper {

    private Context context;
    private final static String DATABASE_NAME = "BookLibrary.db";
    private final static int DATABASE_VERSION = 1;
    private final static String TABLE_NAME = "my_library";
    private final static String COLUMN_ID = "_id";
    private final static String COLUMN_TITLE = "book_title";
    private final static String COLUMN_AUTHOR = "book_author";
    private final static String COLUMN_PAGES = "book_pages";

    public MyDataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_TITLE + " TEXT, " +
                        COLUMN_AUTHOR + " TEXT, " +
                        COLUMN_PAGES + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
