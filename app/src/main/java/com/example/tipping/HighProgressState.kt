package com.example.tipping

import android.widget.TextView

class HighProgressState:EmojiProgressState() {
    override fun setEmojiState(_emojiOutput: TextView) {
        _emojiOutput.text = "( ͡♥ Ĺ̯ ͡♥)"
    }
}