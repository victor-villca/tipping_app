package com.example.tipping

import android.text.Editable
import android.text.TextWatcher
import android.widget.SeekBar

class UserActionListener(billComputation: BillComputation, uiHandler: UiHandler) {
    private val billComputation = billComputation
    private val outputTipping = uiHandler

    fun listenToUserActions(tippingComponents: TippingComponents){
        listenToBaseInput(tippingComponents)
        listenToTipPercentage(tippingComponents)
    }

    private fun listenToBaseInput(tippingComponents: TippingComponents){
        tippingComponents.getBaseInput().addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                billComputation.computeTotal(tippingComponents, outputTipping)
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
    }
    private fun listenToTipPercentage(tippingComponents: TippingComponents){
        tippingComponents.getPercentageSeeker().setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                billComputation.computeTotal(tippingComponents, outputTipping)
                outputTipping.manageEmojis(tippingComponents)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
    }
}