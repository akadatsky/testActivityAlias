package com.akadatsky.testactivityalias

import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enable.setOnClickListener {
            enableActivity()
        }

        disable.setOnClickListener {
            disableActivity()
        }

        call.setOnClickListener {
            startDialActivity("+380671234567")
        }
    }

    private val aliasActivity = "com.akadatsky.testactivityalias.PhoneActivityAlias"

    private fun disableActivity() {
        val componentName = ComponentName(packageName, aliasActivity)
        packageManager.setComponentEnabledSetting(
            componentName,
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    private fun enableActivity() {
        val componentName = ComponentName(packageName, aliasActivity)
        packageManager.setComponentEnabledSetting(
            componentName,
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    private fun startDialActivity(phone: String) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$phone")
        startActivity(intent)
    }
}
