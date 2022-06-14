package com.funkoapp.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.funkoapp.model.Funkoapp

@Database(entities = [Funkoapp::class],version=1, exportSchema = false)
abstract class FunkoappDatabase : RoomDatabase(){
    abstract fun funkoappDao():FunkoappDao

    companion object {
        @Volatile
        private var INSTANCE : FunkoappDatabase? = null
        fun getDatabase(context: android.content.Context): FunkoappDatabase{
            val temInstance = INSTANCE
            if (temInstance != null){
                return temInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FunkoappDatabase::class.java,
                    "funkoapp_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}