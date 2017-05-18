package io.github.chncs23.cooldownbutton

import android.content.Context
import android.util.AttributeSet
import android.widget.Button


class CooldownButton : Button {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    var delayInSeconds: Long = 0

    var listener: OnPostDelayListener? = null

    override fun performClick(): Boolean {
        isEnabled = false
        postDelayed({
            isEnabled = true
            if (listener != null)
                listener!!.onPostDelay()
        }, delayInSeconds * 1000)

        return super.performClick()
    }

    fun setDelay(delayInSeconds: Long) {
        this.delayInSeconds = delayInSeconds
    }

    fun setOnPostDelayListener(listener: OnPostDelayListener) {
        this.listener = listener
    }

    class OnPostDelayListener(val listener: () -> Unit) {
        fun onPostDelay() {
            listener()
        }
    }
}
