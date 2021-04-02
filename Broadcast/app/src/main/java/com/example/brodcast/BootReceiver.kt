package com.example.brodcast


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

                val it = Intent(context, MainActivity::class.java)
                it.setAction(Intent.ACTION_BOOT_COMPLETED)
                 context.startActivity(it)

        Toast.makeText(context, "Dispositivo ligado", Toast.LENGTH_SHORT).show()

        }

    }









