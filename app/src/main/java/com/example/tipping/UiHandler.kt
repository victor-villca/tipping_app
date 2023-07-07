package com.example.tipping

class OutputTipping(tippingComponents: TippingComponents) {
    private val tippingComponents = tippingComponents
    fun manageEmojis(){
        var progress: Int = tippingComponents.percentageSeeker.progress
        if (progress < 10){
            tippingComponents.emoji.text = "( ͡◔ Ĺ̯ ͡◔)"
        }else if (progress>20){
            tippingComponents.emoji.text = "( ͡♥ Ĺ̯ ͡♥)"
        }else{
            tippingComponents.emoji.text = "( ͡◓ ͜ʖ ͡◓)"
        }
    }

}