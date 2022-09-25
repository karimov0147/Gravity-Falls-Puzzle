package com.example.game16.utils

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

object Constant {
    const val DB_NAME = "game"
    const val DB_VERSION = 1
    // fields
    const val TABLE_NAME = "scores"
    const val ID = "id"
    const val NAME = "name"
    const val STEPS = "steps"
    const val TIME = "time"
    const val TYPE = "type"
    lateinit var edit : SharedPreferences.Editor
    lateinit var share : SharedPreferences
    fun SharedPreferences1(app: Context){
        share = app.getSharedPreferences("data" , Context.MODE_PRIVATE )
        edit = share.edit()
    }

    fun setData(data :Boolean){
        edit.putBoolean("data" , data)
    }

    fun getData() : Boolean{
    return share.getBoolean("data" , false )
    }
}