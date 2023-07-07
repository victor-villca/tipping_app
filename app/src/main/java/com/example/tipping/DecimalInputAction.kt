package com.example.tipping

import android.text.Editable
import android.text.TextWatcher

class DecimalInputAction(private val billComputation: BillComputation, private val uiHandler: UiHandler):UsersActionable {
    override fun listenToAction(tippingComponents: TippingComponents) {
        tippingComponents.getBaseInput().addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                billComputation.computeTotal(tippingComponents, uiHandler)
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
    }

}