package com.bme.szotanulo.ui.practice

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bme.szotanulo.R
import com.bme.szotanulo.databinding.MainFragmentBinding
import com.bme.szotanulo.databinding.PracticeFragmentBinding
import com.bme.szotanulo.ui.main.MainViewModel

class PracticeFragment : Fragment() {
    private var _binding: PracticeFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: PracticeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[PracticeViewModel::class.java];

        _binding = PracticeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}