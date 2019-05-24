package com.akadatsky.testactivityalias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_phone.*

class PhoneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)

        if (intent?.action == Intent.ACTION_DIAL) {
            intent?.data?.let {
                textView.text = it.schemeSpecificPart
            }
        }

    }
}
