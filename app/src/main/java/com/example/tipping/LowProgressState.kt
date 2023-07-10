package com.example.tipping

import android.widget.TextView

class LowProgressState: EmojiProgressState() {
    override fun setEmojiState(_emojiOutput: TextView) {
        _emojiOutput.text = "( ͡◔ Ĺ̯ ͡◔)"
    }
}