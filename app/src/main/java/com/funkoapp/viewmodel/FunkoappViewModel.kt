package com.funkoapp.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.funkoapp.data.FunkoappDatabase
import com.funkoapp.model.Funkoapp
import com.funkoapp.repository.FunkoappRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FunkoappViewModel(application: Application) : AndroidViewModel(application) {

    val getAllData: LiveData<List<Funkoapp>>

    //Esta es la menera de como accedo al repositorio desde el view model
    private val repository : FunkoappRepository

    //Se inicializan los atributos anteriores de esta clase
    init {
        val funkoappDao = FunkoappDatabase.getDatabase(application).funkoappDao()
        repository = FunkoappRepository(funkoappDao)
        getAllData = repository.getAllData
    }
    //Esta funcion de alto nivel llama al subproceso de I/O para grabar un regristro Lugar
    fun addfunkoapp(funkoapp:Funkoapp){
        viewModelScope.launch(Dispatchers.IO){
            repository.addFunkoapp(funkoapp)
        }
    }
    //Esta funcion de alto nivel llama al subproceso de I/O para actualizar un regristro Lugar
    fun updatefunkoapp(funkoapp:Funkoapp){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateFunkoapp(funkoapp)
        }
    }
    //Esta funcion de alto nivel llama al subproceso de I/O para eliminar un regristro Lugar
    fun deletefunkoapp(funkoapp:Funkoapp){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteFunkoapp(funkoapp)
        }
    }
}