package com.cs4520.assignment3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class HomeFragment : Fragment() {
    private lateinit var binding: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflater.inflate(R.layout.fragment_home, container, false)
        return binding.rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.findViewById<Button>(R.id.button_mvp).setOnClickListener {
            Navigation.findNavController(binding).navigate(R.id.action_home_to_mvp)
        }

        binding.findViewById<Button>(R.id.button_mvvm).setOnClickListener {
            Navigation.findNavController(binding).navigate(R.id.action_home_to_mvvm)
        }
    }
}