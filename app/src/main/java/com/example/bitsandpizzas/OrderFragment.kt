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
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class OrderFragment : Fragment() {
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_order, container, false)

        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        val fab = view.findViewById<FloatingActionButton>(R.id.fab)

        fab.setOnClickListener {
            val typesPizzas = view.findViewById<RadioGroup>(R.id.types_pizzas)

            var text = ""
            if (typesPizzas.checkedRadioButtonId == -1) {
                text = "Выберите пиццу"
                Toast.makeText(activity, text, Toast.LENGTH_LONG).show()
            } else {
                text += (when (typesPizzas.checkedRadioButtonId) {
                    R.id.roman -> "Римская пицца"
                    else -> "Сицилийская пицца"
                })
                val parmesan = view.findViewById<Chip>(R.id.parmesan)
                val chiliOil = view.findViewById<Chip>(R.id.chili_oil)
                text += if (parmesan.isChecked) ", с пармезаном" else ""
                text += if (chiliOil.isChecked) ", с острым соусом" else ""
                Snackbar.make(fab, text, Snackbar.LENGTH_LONG).show()
            }
        }
        return view
    }
}