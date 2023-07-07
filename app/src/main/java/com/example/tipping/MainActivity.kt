package com.example.tipping

import android.os.Bundle
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var tippingComponents : TippingComponents
    private lateinit var userActionListener: UserActionListener
    private lateinit var billComputation: BillComputation
    private lateinit var uiHandler: UiHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        init()
        userActionListener.listenToUserActions(tippingComponents)
    }

    private fun init(){
        billComputation = BillComputation()
        uiHandler = UiHandler()
        val decimalInputAction = DecimalInputAction(billComputation, uiHandler)
        val seekerBarAction = SeekerBarAction(billComputation, uiHandler)
        tippingComponents = TippingComponents(this)
        userActionListener = UserActionListener(listOf(decimalInputAction, seekerBarAction))
    }

}
