package com.example.tipping

import android.widget.TextView

class UiHandler() {
    fun manageEmojis(tippingComponents: TippingComponents){
        var progress: Int = tippingComponents.getPercentageSeeker().progress
        val emojiUI: TextView = tippingComponents.getEmoji();

        val lowProgress = LowProgressState()
        val highProgressState = HighProgressState()
        val defaultProgressState = DefaultProgressState()

        val emojiState: EmojiProgressState =  when{
            progress<10 -> lowProgress
            progress>20 ->highProgressState
            else-> defaultProgressState
        }
        emojiState.setEmojiState(emojiUI)
    }
    fun  updateTippingComponents(tippingComponents: TippingComponents, tip:Double, total:Double){
        tippingComponents.getTotalTip().text = "$tip $"
        tippingComponents.getTotalAmount().text = "$total $"
        tippingComponents.getPercentageLabel().text = tippingComponents.getPercentageSeeker().progress.toString() + " %"
    }

}