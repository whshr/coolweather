package com.example.sam.helloword;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDB extends SQLiteOpenHelper {
    //参数1：上下文，参数2：数据库名称，参数3：有表对象，参数4：数据库版本
    public MyDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //构造方法，创建数据库

    //当数据库创建时调用
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表
        String createtable="create table if not exists users(id integer primary key autoincrement,username text,password text,sex text)";
        db.execSQL(createtable);
    }
    //用于数据库版本的更新升级
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
        onCreate(db);

    }
}
