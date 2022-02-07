package com.example.harrypotter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.harrypotter.databinding.FragmentHpBinding

class HPFragment : Fragment(R.layout.fragment_hp) {
    private lateinit var binding: FragmentHpBinding
    private val viewModel: HPViewModel by viewModels()
    private lateinit var adapterHP: HPAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getCharacters()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHpBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        observe()
    }

    private fun observe() {
        viewModel.characters.observe(viewLifecycleOwner) {
            adapterHP.submitList(it)
        }
    }

  private fun initList() {
        adapterHP = HPAdapter()
        with(binding.recyclerView) {
            adapter = adapterHP
            layoutManager = LinearLayoutManager(requireContext())
            val dividerItemDecoration =
                DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            addItemDecoration(dividerItemDecoration)
            setHasFixedSize(true)
        }
    }
}