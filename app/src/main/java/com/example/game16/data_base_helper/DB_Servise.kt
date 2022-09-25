package com.example.game16.data_base_helper

import com.example.game16.models.Score

interface DB_Servise {

    fun addRecord(score : Score)

    fun getAllRecord() : ArrayList<Score>

    fun deleteAll()
}