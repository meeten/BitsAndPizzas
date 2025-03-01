package com.example.bitsandpizzas

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bitsandpizzas.databinding.FragmentOrderBinding
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class OrderFragment : Fragment() {
    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderBinding.inflate(inflater)
        val view = binding.root

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener {
            var text = ""
            if (binding.typesPizzas.checkedRadioButtonId == -1) {
                text = "Выберите пиццу"
                Toast.makeText(activity, text, Toast.LENGTH_LONG).show()
            } else {
                text += (when (binding.typesPizzas.checkedRadioButtonId) {
                    R.id.roman -> "Римская пицца"
                    else -> "Сицилийская пицца"
                })
                text += if (binding.parmesan.isChecked) ", с пармезаном" else ""
                text += if (binding.chiliOil.isChecked) ", с острым соусом" else ""
                Snackbar.make(binding.fab, text, Snackbar.LENGTH_LONG).show()
            }
        }
        return view
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}