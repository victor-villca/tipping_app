package com.example.tipping

import android.widget.TextView

class DefaultProgressState: EmojiProgressState() {
    override fun setEmojiState(_emojiOutput: TextView) {
        _emojiOutput.text = "( ͡◓ ͜ʖ ͡◓)"
    }
}