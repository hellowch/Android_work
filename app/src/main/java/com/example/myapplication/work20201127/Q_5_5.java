package com.example.myapplication.work20201127;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import com.example.myapplication.R;

public class Q_5_5 extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_5_5);

        databaseHelper = new DatabaseHelper(getApplicationContext());
        //打开或创建数据库
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
    }

    //添加数据
    public void create(View v){
        //获取数据库对象
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        //添加 sql语句
        db.execSQL("insert into staff(name,sex,department,salary) values(?,?,?,?)",new Object[]{"Tom","male","computer","5400"});
        db.execSQL("insert into staff(name,sex,department,salary) values(?,?,?,?)",new Object[]{"Einstein","male","computer","4800"});
        db.execSQL("insert into staff(name,sex,department,salary) values(?,?,?,?)",new Object[]{"Lily","female","1.68",""});
        db.execSQL("insert into staff(name,sex,department,salary) values(?,?,?,?)",new Object[]{"Warner","male","",""});
        db.execSQL("insert into staff(name,sex,department,salary) values(?,?,?,?)",new Object[]{"Napoleon","male","",""});
        //关闭数据库
        db.close();

        System.out.println("添加完毕");
    }

    //删除数据
    public void delete(View v){
        //获取数据库对象
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        //添加 sql语句
        db.execSQL("delete from staff where _id=?",new Object[]{"5"});
        //关闭数据库
        db.close();

        System.out.println("删除完毕");
    }

    //修改数据
    public void update(View v){
        //获取数据库对象
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        //添加 sql语句
        db.execSQL("update staff set name=? where _id=?",new Object[]{"abcccc","4"});
        //关闭数据库
        db.close();

        System.out.println("修改完毕");
    }

    //查询数据
    public void select(View v){
        //获取数据库对象
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from staff",null);
        if (cursor != null && cursor.getCount()>0 ){
            while (cursor.moveToNext()){
                //获取数据，并输出
                String _id = cursor.getString(0);
                String name = cursor.getString(1);
                String sex = cursor.getString(2);
                String department = cursor.getString(3);
                String salary = cursor.getString(4);
                System.out.println(_id + " " + name + " " + sex + " " + department + " " + salary);
            }
        }

        System.out.println("查询完毕");
    }
}