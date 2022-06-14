package com.funkoapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.funkoapp.databinding.FragmentFunkoappBinding
import com.funkoapp.databinding.FunkoappFilaBinding
import com.funkoapp.model.Funkoapp
import com.funkoapp.ui.funkoapp.FunkoappFragmentDirections

class FunkoappAdapter : RecyclerView.Adapter<FunkoappAdapter.FunkoappViewHolder>(){
    //Una lista para almacenar la informacion de los funkos
    private var listaFunkoapp = emptyList<Funkoapp>()

    inner class FunkoappViewHolder(private val itemBinding: FunkoappFilaBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun dibuja(funkoapp: Funkoapp){
            itemBinding.tvNombre.text = funkoapp.nombre
            itemBinding.tvNumero.id = funkoapp.numero
            itemBinding.tvEtiqueta.text= funkoapp.sticker
            itemBinding.tvSegundaetiqueta.text = funkoapp.segundasticker
            itemBinding.tvFechacompra.text= funkoapp.fechaComprado
            itemBinding.tvPrecio.text= funkoapp.precio
            itemBinding.tvTienda.text= funkoapp.tienda

            itemBinding.vistaFila.setOnClickListener{
                val accion = FunkoappFragmentDirections
                    .actionNavFunkoappToAddFunkoAppFragment()
                itemView.findNavController().navigate(accion)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FunkoappViewHolder {
        //Inflate = "renderizar el cardview"
        val itemBinding = FunkoappFilaBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return FunkoappViewHolder(itemBinding)
    }
    override fun onBindViewHolder(holder: FunkoappViewHolder, position: Int) {
        val lugar = listaFunkoapp[position]
        holder.dibuja(lugar)
    }
    override fun getItemCount(): Int {
        return listaFunkoapp.size
    }
    fun setData(funkoapp: List<Funkoapp>){
        this.listaFunkoapp = funkoapp
        //La siguiente instruccion redibuja la lista del reciclador
        notifyDataSetChanged()
    }
}