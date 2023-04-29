package com.example.mvvm_example.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.mvvm_example.databinding.ActivityMainFragmentBinding
import com.example.mvvm_example.viewmodel.MainViewModel

class MainFragment: Fragment() {

    private var _binding: ActivityMainFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ActivityMainFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()
        fragmentTextUpdateObserver()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupClickListeners() {
        binding.fragmentButton.setOnClickListener { viewModel.getUpdatedText() }
    }

    private fun fragmentTextUpdateObserver() {
        viewModel.uiTextLiveData.observe(viewLifecycleOwner, Observer { updatedText ->
            binding.fragmentTextView.text = updatedText
        })
    }
}