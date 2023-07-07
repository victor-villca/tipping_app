package com.example.tipping

class UiHandler() {
    fun manageEmojis(tippingComponents: TippingComponents){
        var progress: Int = tippingComponents.getPercentageSeeker().progress
        if (progress < 10){
            tippingComponents.getEmoji().text = "( ͡◔ Ĺ̯ ͡◔)"
        }else if (progress>20){
            tippingComponents.getEmoji().text = "( ͡♥ Ĺ̯ ͡♥)"
        }else{
            tippingComponents.getEmoji().text = "( ͡◓ ͜ʖ ͡◓)"
        }
    }
    fun  updateTippingComponents(tippingComponents: TippingComponents, tip:Double, total:Double){
        tippingComponents.getTotalTip().text = "$tip $"
        tippingComponents.getTotalAmount().text = "$total $"
        tippingComponents.getPercentageLabel().text = tippingComponents.getPercentageSeeker().progress.toString() + " %"
    }

}