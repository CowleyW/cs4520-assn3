package com.cs4520.assignment3.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.R

class MVPFragment : Fragment() {
    private lateinit var binding: View
    private lateinit var presenter: Presenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflater.inflate(R.layout.fragment_mvp, container, false)
        return binding.rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = Presenter(this)

        binding.findViewById<Button>(R.id.button_mvp_add).setOnClickListener {
            presenter.onAdd(getNum1(), getNum2())
            resetInputs()
        }
        binding.findViewById<Button>(R.id.button_mvp_subtract).setOnClickListener {
            presenter.onSubtract(getNum1(), getNum2())
            resetInputs()
        }
        binding.findViewById<Button>(R.id.button_mvp_multiply).setOnClickListener {
            presenter.onMultiply(getNum1(), getNum2())
            resetInputs()
        }
        binding.findViewById<Button>(R.id.button_mvp_divide).setOnClickListener {
            presenter.onDivide(getNum1(), getNum2())
            resetInputs()
        }
    }

    private fun getNum1(): Double {
        return binding.findViewById<EditText>(R.id.mvp_input_num_1).text.toString().toDoubleOrNull()?: Double.NaN
    }

    private fun getNum2(): Double {
        return binding.findViewById<EditText>(R.id.mvp_input_num_2).text.toString().toDoubleOrNull()?: Double.NaN
    }

    fun setResultText(result: String) {
        binding.findViewById<TextView>(R.id.mvp_result_text).text = result
    }

    fun onError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun resetInputs() {
        binding.findViewById<EditText>(R.id.mvp_input_num_1).text.clear()
        binding.findViewById<EditText>(R.id.mvp_input_num_2).text.clear()
    }
}