package io.github.chncs23.cooldownbutton.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import io.github.chncs23.cooldownbutton.CooldownButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: CooldownButton = findViewById(R.id.cooldown) as CooldownButton
        button.setDelay(1)
        button.setOnClickListener {
            Toast.makeText(this, "Button Pressed", Toast.LENGTH_LONG).show()
        }

        button.setOnPostDelayListener(
                CooldownButton.OnPostDelayListener { Toast.makeText(this, "after delay", Toast.LENGTH_SHORT).show() })
    }
}
