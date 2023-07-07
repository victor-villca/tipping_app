package com.example.tipping

class BillComputation() {
    fun computeTotal(tippingComponents: TippingComponents, uiHandler: UiHandler){
        var base: Double = try {
            java.lang.Double.parseDouble(tippingComponents.getBaseInput().text.toString())
        } catch (e:NumberFormatException){0.0}
        var tip: Double = (tippingComponents.getPercentageSeeker().progress * base)/ 100
        var total: Double = base+ java.lang.Double.parseDouble(tip.toString())
        uiHandler.updateTippingComponents(tippingComponents, tip, total)

    }
}