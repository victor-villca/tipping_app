package com.example.tipping

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.activity.ComponentActivity
import java.lang.Double.parseDouble

class MainActivity : ComponentActivity() {
    private lateinit var baseInput: EditText
    private lateinit var percentageLabel: TextView
    private lateinit var percentageSeeker: SeekBar
    private lateinit var totalTip: TextView
    private lateinit var totalAmount: TextView
    private lateinit var emoji:TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        baseInput = findViewById(R.id.baseInput)
        percentageLabel = findViewById(R.id.percentageTipLabel)
        percentageSeeker = findViewById(R.id.tipSeekBar)
        totalTip = findViewById(R.id.tipAmount)
        totalAmount = findViewById(R.id.totalAmount)
        emoji = findViewById(R.id.emoji)
        listenToBaseInput(baseInput)
        listenToTipPercentage(percentageSeeker)
    }

    private fun listenToBaseInput(baseInput:EditText){
        baseInput.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                computeTotal()
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
    }

    private fun listenToTipPercentage(tip: SeekBar){
        tip.setOnSeekBarChangeListener(object :OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                computeTotal()
                manageEmojis()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
    }

    fun computeTotal(){
        var base: Double = try { parseDouble(baseInput.text.toString()) } catch (e:NumberFormatException){0.0}
        var tip: Double = (percentageSeeker.progress * base)/ 100
        var total: Double = base+ parseDouble( tip.toString())
        totalTip.text = "$tip $"
        totalAmount.text = "$total $"
        percentageLabel.text = percentageSeeker.progress.toString() + " %"
    }
    fun manageEmojis(){
        var progress: Int = percentageSeeker.progress
        if (progress < 10){
            emoji.text = "( ͡◔ Ĺ̯ ͡◔)"
        }else if (progress>20){
            emoji.text = "( ͡♥ Ĺ̯ ͡♥)"
        }else{
            emoji.text = "( ͡◓ ͜ʖ ͡◓)"
        }
    }

}
