package com.funkoapp.ui.funkoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.funkoapp.R
import com.funkoapp.adapter.FunkoappAdapter
import com.funkoapp.databinding.FragmentAddFunkoAppBinding
import com.funkoapp.databinding.FragmentFunkoappBinding
import com.funkoapp.model.Funkoapp
import com.funkoapp.viewmodel.FunkoappViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddFunkoAppFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddFunkoAppFragment : Fragment() {
    private lateinit var funkoappViewModel: FunkoappViewModel
    private var _bingind: FragmentAddFunkoAppBinding? = null
    private val binding get() = _bingind!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {funkoappViewModel = ViewModelProvider (this)[FunkoappViewModel::class.java]
        _bingind = FragmentAddFunkoAppBinding.inflate(layoutInflater, container, false)

        //Se programa la accion para pasarse a AddLugar
        binding.btAgregar.setOnClickListener{
            findNavController().navigate(R.id.action_nav_funkoapp_to_addFunkoAppFragment)

        }
        return binding.root
    }
    private fun addFunkoapp() {
        val nombre=binding.etNombre.text.toString()
        val numero=binding.etNumero.id
        val etiqueta=binding.etSticker.text.toString()
        val segundaetiqueta=binding.etSegundaetiqueta.text.toString()
        val fechacomprado=binding.etFechacompra.text.toString()
        val precio=binding.etPrecio.text.toString()
        val tienda=binding.etPrecio.text.toString()

        if(nombre.isNotEmpty()){
            val funkoapp = Funkoapp(0, nombre, numero,etiqueta, segundaetiqueta,fechacomprado,precio,tienda)
            funkoappViewModel.addfunkoapp(funkoapp)
            Toast.makeText(requireContext(),getString(R.string.funkoAdded), Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFunkoAppFragment_to_nav_funkoapp)
        }else{
            Toast.makeText(requireContext(),getString(R.string.noData), Toast.LENGTH_SHORT).show()
        }
    }
}