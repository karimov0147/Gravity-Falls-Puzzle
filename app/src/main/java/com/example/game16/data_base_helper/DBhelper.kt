package com.example.game16.data_base_helper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.game16.models.Score
import com.example.game16.utils.Constant

class DBhelper(context : Context) : SQLiteOpenHelper(context , Constant.DB_NAME , null , Constant.DB_VERSION ) , DB_Servise {

    override fun onCreate(db: SQLiteDatabase?) {
        var query = "create table ${Constant.TABLE_NAME} ( ${Constant.ID} integer not null primary key autoincrement unique , ${Constant.NAME} text not null , ${Constant.STEPS} integer  not null , ${Constant.TIME} text not null , ${Constant.TYPE} text not null)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists ${Constant.TABLE_NAME}")
        onCreate(db)
    }

    override fun addRecord(score : Score) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Constant.NAME , score.name)
        contentValues.put(Constant.STEPS , score.step)
        contentValues.put(Constant.TIME , score.time)
        contentValues.put(Constant.TYPE, score.type)
        database.insert(Constant.TABLE_NAME , null , contentValues)
        database.close()

    }

    override fun getAllRecord() : ArrayList<Score> {
        var scoreList = ArrayList<Score>()
        var query = "select * from ${Constant.TABLE_NAME}"
        val database = this.readableDatabase
        var cursor = database.rawQuery(query , null)
        if (cursor.moveToFirst()){
            do {
                var id = cursor.getInt(0)
                var name = cursor.getString(1)
                var step = cursor.getInt(2)
                var time = cursor.getString(3)
                var type = cursor.getString(4)
                scoreList.add(Score(name , step , time , type))
            }while (cursor.moveToNext())
            }
        return scoreList
    }

    override fun deleteAll() {
        var database = writableDatabase
        database.delete(Constant.TABLE_NAME , null , null)
        database.close()
    }

}

