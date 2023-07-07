package com.example.tipping

class UserActionListener(private val actionable: List<UsersActionable>) {
    fun listenToUserActions(tippingComponents: TippingComponents) {
        actionable.forEach { action ->
            action.listenToAction(tippingComponents)
        }
    }
}
