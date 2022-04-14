package com.example.modul3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.modul3.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button1.setOnClickListener{ calculate() }
        binding.inputEditText.setOnKeyListener{ view, keyCode, _ ->
            handleKeyEvent(view, keyCode)}
    }

    private fun  calculate(){
        val stringInText = binding.inputEditText.text.toString()
        val inputNilai = stringInText.toDoubleOrNull()

        if (inputNilai == null){
            binding.hasilCal.text = ""
            return
        }

        val radioChoice = when (binding.radio1.checkedRadioButtonId){
            R.id.euro -> 15617
            R.id.USD -> 14355
            R.id.JPY -> 114
            else -> 3827
        }

        var hasilKonversi =  inputNilai * radioChoice

        val indonesianLocale = Locale("in", "ID")
        val formatHasil = NumberFormat.getCurrencyInstance(indonesianLocale).format(hasilKonversi)
        binding.hasilCal.text = getString(R.string.hasil, formatHasil)
    }

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}
