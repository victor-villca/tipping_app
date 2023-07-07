package com.example.tipping

import android.widget.SeekBar

class SeekerBarAction(private val billComputation: BillComputation, private val uiHandler: UiHandler):UsersActionable {
    override fun listenToAction(tippingComponents: TippingComponents) {
        tippingComponents.getPercentageSeeker().setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                billComputation.computeTotal(tippingComponents, uiHandler)
                uiHandler.manageEmojis(tippingComponents)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
    }
}