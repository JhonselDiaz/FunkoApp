package com.funkoapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.funkoapp.model.Funkoapp

@Dao
interface FunkoappDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFunkoapp (funkoapp: Funkoapp)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateFunkoapp(funkoapp: Funkoapp)

    @Delete
    suspend fun deleteFunkoapp(funkoapp: Funkoapp)

    @Query("Select * From FUNKOAPP")
    fun getAllData() : LiveData<List<Funkoapp>>
}