package com.bme.szotanulo.ui.edit

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bme.szotanulo.R
import com.bme.szotanulo.databinding.EditFragmentBinding

class EditFragment : Fragment() {
    private var _binding: EditFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: EditViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[EditViewModel::class.java];

        _binding = EditFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}