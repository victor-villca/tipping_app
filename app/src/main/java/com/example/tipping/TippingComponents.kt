package com.example.tipping

import android.widget.*
import android.app.Activity

class TippingComponents(private val activity: Activity) {
    private lateinit var baseInput: EditText
    private lateinit var percentageLabel: TextView
    private lateinit var percentageSeeker: SeekBar
    private lateinit var totalTip: TextView
    private lateinit var totalAmount: TextView
    private lateinit var emoji: TextView
    init {
        findIdComponents()
    }

    private fun findIdComponents() {
        baseInput = activity.findViewById(R.id.baseInput)
        percentageLabel = activity.findViewById(R.id.percentageTipLabel)
        percentageSeeker = activity.findViewById(R.id.tipSeekBar)
        totalTip = activity.findViewById(R.id.tipAmount)
        totalAmount = activity.findViewById(R.id.totalAmount)
        emoji = activity.findViewById(R.id.emoji)
    }

    fun getBaseInput(): EditText {
        return baseInput
    }

    fun getPercentageLabel(): TextView {
        return percentageLabel
    }

    fun getPercentageSeeker(): SeekBar {
        return percentageSeeker
    }

    fun getTotalTip(): TextView {
        return totalTip
    }

    fun getTotalAmount(): TextView {
        return totalAmount
    }


    fun getEmoji(): TextView {
        return emoji
    }
}