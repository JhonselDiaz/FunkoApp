package com.funkoapp.ui.funkoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.funkoapp.databinding.FragmentFunkoappBinding
import com.funkoapp.viewmodel.FunkoappViewModel

class FunkoappFragment : Fragment() {

    private var _binding: FragmentFunkoappBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val funkoappViewModel =
            ViewModelProvider(this).get(FunkoappViewModel::class.java)

        _binding = FragmentFunkoappBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        funkoappViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}