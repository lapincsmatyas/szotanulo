package com.bme.szotanulo.ui.edit

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.bme.szotanulo.R
import com.bme.szotanulo.databinding.EditFragmentBinding
import com.bme.szotanulo.databinding.MainFragmentBinding
import com.bme.szotanulo.ui.main.MainFragmentDirections
import com.bme.szotanulo.ui.main.MainViewModel

class EditFragment : Fragment() {
    private lateinit var binding: EditFragmentBinding

    private lateinit var viewModel: EditViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.edit_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this)[EditViewModel::class.java];

        binding.mainButton.setOnClickListener{onMainButton()}

        return binding.root
    }

    private fun onMainButton(){
        val action = EditFragmentDirections.actionEditFragmentToMainFragment();
        findNavController().navigate(action)
    }
}