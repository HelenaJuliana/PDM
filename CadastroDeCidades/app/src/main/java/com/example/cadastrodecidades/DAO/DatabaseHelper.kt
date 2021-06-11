package com.example.cadastrodecidades.DAO

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper  (context: Context): SQLiteOpenHelper(context, "cores.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sqlQuery = "" +
                "create table cidade (" +
                "id integer primary key autoincrement," +
                "nome text," +
                "codigo integer)"

        db?.execSQL(sqlQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table cidade")
        this.onCreate(db)
    }
}
