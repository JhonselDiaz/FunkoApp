package com.funkoapp.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
@Parcelize
@Entity(tableName = "funkoapp")
data class Funkoapp(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "nombre")
    val nombre:String,
    @ColumnInfo(name = "numero")
    val numero:Int,
    @ColumnInfo(name = "sticker")
    val sticker:String,
    @ColumnInfo(name = "segundasticker")
    val segundasticker:String?,
    @ColumnInfo(name = "fechaComprado")
    val fechaComprado:String?,
    @ColumnInfo(name = "precio")
    val precio:String?,
    @ColumnInfo(name = "tienda")
    val tienda:String?
): Parcelable

