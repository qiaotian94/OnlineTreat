package com.example.qiaotian.onlinetreatapp.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

/**
 * Created by qiaotian on 2018/4/27.
 */

public class DBHelper extends SQLiteOpenHelper {


    public static final String CREATE_USERDATA="create table userData("
            +"id integer primary key autoincrement," + "password text)";

    public static final String CREATE_USEMES="create table userMes("
            + "id integer primary key autoincrement," + "name text,"
            + "sex text," + "age integer," + "email text)";

    public static final String CREATE_ILLRECORD="create table illRecord("
            + "id integer primary key autoincrement," + "date text," + "body text )";

    public static final String CREATE_HEALTHY="create table healthy("
            +"id integer primary key autoincrement," + "view1 text," + "view2 text," +
            "view3 text," + "view4 text)";

    public Context mContext;

    public DBHelper(Context context, String name,
                    SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext=context;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USERDATA);
        sqLiteDatabase.execSQL(CREATE_USEMES);
        sqLiteDatabase.execSQL(CREATE_ILLRECORD);
        sqLiteDatabase.execSQL(CREATE_HEALTHY);
    }
}
