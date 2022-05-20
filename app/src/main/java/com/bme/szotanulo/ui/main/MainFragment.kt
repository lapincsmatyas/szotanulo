package com.bme.szotanulo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bme.szotanulo.R
import com.bme.szotanulo.databinding.MainFragmentBinding
import com.bme.szotanulo.model.Card
import com.bme.szotanulo.ui.practice.PracticeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
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

        val adapter = CardItemAdapter()
        binding.cardList.adapter = adapter
        viewModel.response.observe(viewLifecycleOwner) {
            it?.let {
                adapter.data = it
            }
        }

        binding.createButton.setOnClickListener{onCreateCard()}

        return binding.root
    }

    private fun onCreateCard(){
        val action = MainFragmentDirections.actionMainFragmentToEditFragment();
        findNavController().navigate(action)
    }
}