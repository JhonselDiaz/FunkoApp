package com.funkoapp.repository

import androidx.lifecycle.LiveData
import com.funkoapp.data.FunkoappDao
import com.funkoapp.model.Funkoapp

class FunkoappRepository (private val funkoappDao: FunkoappDao){
    //Se implementa las funciones de la interface

    //Se crea un objeto que el arrayList de los registros de la tabla
    val getAllData: LiveData<List<Funkoapp>> = funkoappDao.getAllData()

    //se define la funcion para insertar un Funko en la tabla lugar
    suspend fun addFunkoapp(funkoapp:Funkoapp) {
        funkoappDao.addFunkoapp(funkoapp)
    }
    //se define la funcion para actualizar un Funko en la tabla lugar
    suspend fun updateFunkoapp(funkoapp:Funkoapp) {
        funkoappDao.updateFunkoapp(funkoapp)
    }
    //se define la funcion para eliminar un Funko en la tabla lugar
    suspend fun deleteFunkoapp(funkoapp:Funkoapp){
        funkoappDao.deleteFunkoapp(funkoapp)
    }
}