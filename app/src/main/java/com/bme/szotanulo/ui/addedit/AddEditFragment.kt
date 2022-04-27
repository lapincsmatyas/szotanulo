package com.bme.szotanulo.ui.addedit

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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddEditFragment : Fragment() {
    private lateinit var binding: EditFragmentBinding

    private lateinit var viewModel: AddEditViewModel

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
        viewModel = ViewModelProvider(this)[AddEditViewModel::class.java];

        binding.mainButton.setOnClickListener{onMainButton()}
        binding.mainButton.text = viewModel.card.value?.frontSide

        return binding.root
    }

    private fun onMainButton(){
        val action = AddEditFragmentDirections.actionEditFragmentToMainFragment();
        findNavController().navigate(action)
    }
}