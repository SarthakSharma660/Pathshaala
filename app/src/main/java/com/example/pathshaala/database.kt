package com.example.pathshaala

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class databaseclass(context: Context?) :
    SQLiteOpenHelper(context, "muskan.db", null, 1) {
    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        sqLiteDatabase.execSQL("create table student (id INTEGER PRIMARY KEY AUTOINCREMENT,muskanlogin text,muskanpassword text)")
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {
        onCreate(sqLiteDatabase)
    }
}
