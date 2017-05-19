package io.github.chncs23.cooldownbutton

import android.content.Context
import android.util.AttributeSet
import android.widget.Button


class CooldownButton : Button {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    var delayInSeconds: Long = 0

    var onPostDelayListener: OnPostDelayListener? = null

    override fun performClick(): Boolean {
        isEnabled = false
        postDelayed({
            isEnabled = true
            onPostDelayListener?.let { onPostDelayListener!!.onPostDelay() }

        }, delayInSeconds * 1000)

        return super.performClick()
    }

    interface OnPostDelayListener {
        fun onPostDelay()
    }
}
