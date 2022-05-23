package com.bme.szotanulo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.bme.szotanulo.R
import com.bme.szotanulo.databinding.MainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint


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

        val adapter = CardItemAdapter(CardListener { cardId ->
            Toast.makeText(context, "${cardId}", Toast.LENGTH_LONG).show()
            viewModel.onCardClicked(cardId)
        })

        binding.cardList.adapter = adapter
        binding.cardList.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )

        viewModel.cards.observe(viewLifecycleOwner) {
            it?.let {
                adapter.submitList(it)
            }
        }

        binding.createButton.setOnClickListener{onCreateCard()}

        viewModel.navigateToCardEdit.observe(viewLifecycleOwner, Observer { card ->
            card?.let {
                this.findNavController().navigate(MainFragmentDirections.actionMainFragmentToEditFragment(card))
            }
        })

        viewModel.networkError.observe(viewLifecycleOwner) {
            if(it) {
                Toast.makeText(activity, "Network Error", Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }

    private fun onCreateCard(){
        val action = MainFragmentDirections.actionMainFragmentToEditFragment();
        findNavController().navigate(action)
    }
}