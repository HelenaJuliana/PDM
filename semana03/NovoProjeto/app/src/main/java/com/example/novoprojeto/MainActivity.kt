package com.example.novoprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var botao: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.botao = findViewById(R.id.btnCliqueAqui)

        //this.botao.text = "Eita!"
/*
        this.botao.setOnClickListener({
            var aleatorio = Random()
            this.botao.text = aleatorio.nextInt(60).toString()
        })
 */
        this.botao.setOnClickListener({ clique(it) })

    }

    fun clique(view: View){
        var aleatorio = Random()
        Log.i("NOVOPROJETO", aleatorio.nextInt(60).toString())
    }
}