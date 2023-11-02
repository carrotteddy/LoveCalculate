package com.example.lovecalculate.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "love_table")
data class LoveModel(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    @SerializedName("fname")
    var firstName: String,
    @SerializedName("sname")
    var secondName: String,
    var percentage: String,
    var result: String,
    var creationDate: Long
):Serializable
