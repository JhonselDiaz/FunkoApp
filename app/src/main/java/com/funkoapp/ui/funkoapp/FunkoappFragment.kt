package com.funkoapp.ui.funkoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.funkoapp.R
import com.funkoapp.adapter.FunkoappAdapter
import com.funkoapp.databinding.FragmentFunkoappBinding
import com.funkoapp.viewmodel.FunkoappViewModel

class FunkoappFragment : Fragment() {

    private lateinit var funkoappViewModel: FunkoappViewModel
    private var _binding: FragmentFunkoappBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        funkoappViewModel = ViewModelProvider(this).get(FunkoappViewModel::class.java)
        _binding = FragmentFunkoappBinding.inflate(inflater, container, false)

        binding.fbAgregar.setOnClickListener {
        findNavController().navigate(R.id.action_nav_funkoapp_to_addFunkoAppFragment)
        }
        //Activar el Reciclador -RecyclerView
        val funkoappAdapter = FunkoappAdapter()
        val reciclador = binding.reciclador

        reciclador.adapter = funkoappAdapter
        reciclador.layoutManager = LinearLayoutManager(requireContext())
        funkoappViewModel = ViewModelProvider(this)[FunkoappViewModel::class.java]

        funkoappViewModel.getAllData.observe(viewLifecycleOwner){
                funkosapp -> funkoappAdapter.setData(funkosapp)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}