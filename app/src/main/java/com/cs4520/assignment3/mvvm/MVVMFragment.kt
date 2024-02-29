package com.cs4520.assignment3.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cs4520.assignment3.R

class MVVMFragment : Fragment() {
    private lateinit var view_model: MVVMViewModel
    private lateinit var binding: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflater.inflate(R.layout.fragment_mvvm, container, false)
        return binding.rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view_model = ViewModelProvider(this)[MVVMViewModel::class.java]

        view_model.resultBinding.observe(viewLifecycleOwner) { result ->
            when (result) {
                "ERRNAN" -> {
                    onError("Enter two numbers.")
                }
                "ERRINF" -> {
                    onError("Cannot divide by zero.")
                }
                else -> {
                    binding.findViewById<TextView>(R.id.mvvm_result_text).text = result
                }
            }
        }

        binding.findViewById<Button>(R.id.button_mvvm_add).setOnClickListener {
            view_model.onAdd(getNum1(), getNum2())
            resetInputs()
        }
        binding.findViewById<Button>(R.id.button_mvvm_subtract).setOnClickListener {
            view_model.onSubtract(getNum1(), getNum2())
            resetInputs()
        }
        binding.findViewById<Button>(R.id.button_mvvm_multiply).setOnClickListener {
            view_model.onMultiply(getNum1(), getNum2())
            resetInputs()
        }
        binding.findViewById<Button>(R.id.button_mvvm_divide).setOnClickListener {
            view_model.onDivide(getNum1(), getNum2())
            resetInputs()
        }
    }

    private fun getNum1(): Double {
        return binding.findViewById<EditText>(R.id.mvvm_input_num_1).text.toString().toDoubleOrNull()?: Double.NaN
    }

    private fun getNum2(): Double {
        return binding.findViewById<EditText>(R.id.mvvm_input_num_2).text.toString().toDoubleOrNull()?: Double.NaN
    }

    private fun resetInputs() {
        binding.findViewById<EditText>(R.id.mvvm_input_num_1).text.clear()
        binding.findViewById<EditText>(R.id.mvvm_input_num_2).text.clear()
    }

    fun onError(message: String) {
        binding.findViewById<TextView>(R.id.mvvm_result_text).text = ""
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}