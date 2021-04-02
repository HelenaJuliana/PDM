package com.example.brodcast

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.nio.channels.InterruptedByTimeoutException

class MainActivity : AppCompatActivity() {

    private lateinit var  receiver: BootReceiver


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.receiver = BootReceiver()
    }

    override fun onResume() {
        super.onResume()
        val itf = IntentFilter()
        itf.addAction(Intent.ACTION_USER_PRESENT)
        registerReceiver(this.receiver, itf)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(this.receiver)
    }
}