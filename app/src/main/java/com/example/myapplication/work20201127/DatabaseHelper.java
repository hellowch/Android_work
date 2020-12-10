package com.example.myapplication.work20201127;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper {

    /**
     *  context 上下文
     *   name  数据库的名字
     *  factory   目的创建cursor对象
     *  version    数据库的版本  从1开始
     */
    public DatabaseHelper(Context context) {
        super(context, "staff.db", null, 4);
    }

    /**
     * 当数据库第一次创建的时候调用
     * 那么这个方法特别适合做表结构的初始化 创建表就是写sql语句
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table staff ("
                + "_id integer primary key autoincrement, "
                + "name text, "
                + "sex text,  "
                + "department text,"
                + "salary float)";

        db.execSQL(sql);
    }

    /**
     * 当数据库版本升级的时候调用
     * 这个方法适合做 表结构的更新
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //创建成功，日志输出提示
        Log.i("DatabaseHelper","数据库创建成功");

    }
}