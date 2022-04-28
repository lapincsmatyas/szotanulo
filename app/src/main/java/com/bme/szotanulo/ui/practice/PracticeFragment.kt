package com.bme.szotanulo.ui.practice

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.bme.szotanulo.R
import com.bme.szotanulo.databinding.PracticeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PracticeFragment : Fragment() {
    private lateinit var binding: PracticeFragmentBinding

    private lateinit var viewModel: PracticeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.practice_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this)[PracticeViewModel::class.java];

        binding.mainButton.setOnClickListener{onMainButton()}
        binding.editButton.setOnClickListener{onEditButton()}

        return binding.root
    }

    private fun onMainButton(){
        val action = PracticeFragmentDirections.actionPracticeFragmentToMainFragment();
        findNavController().navigate(action)
    }
    private fun onEditButton(){
        val action = PracticeFragmentDirections.actionPracticeFragmentToEditFragment();
        findNavController().navigate(action)
    }
}