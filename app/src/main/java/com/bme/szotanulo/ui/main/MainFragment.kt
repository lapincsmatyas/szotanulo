package com.bme.szotanulo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bme.szotanulo.R
import com.bme.szotanulo.databinding.MainFragmentBinding

class MainFragment : Fragment() {
    private lateinit var binding: MainFragmentBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.main_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this)[MainViewModel::class.java];

        binding.editButton.setOnClickListener{onEditButton()}
        binding.practiceButton.setOnClickListener{onPracticeButton()}

        return binding.root
    }

    private fun onEditButton(){
        val action = MainFragmentDirections.actionMainFragmentToEditFragment();
        findNavController().navigate(action)
    }

    private fun onPracticeButton(){
        val action = MainFragmentDirections.actionMainFragmentToPracticeFragment();
        findNavController().navigate(action)
    }
}