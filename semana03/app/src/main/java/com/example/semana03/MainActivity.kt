package com.example.semana03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import java.util.*
import kotlin.collections.HashSet

class MainActivity : AppCompatActivity() {
    private lateinit var botao: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.botao = findViewById(R.id.btnCliqueAqui)



        this.botao.setOnClickListener({ clique(it) })

    }

    fun clique(view: View) {
        var aleatorio =   Random()
        var sorteio = HashSet<Int>()

        while (sorteio.size < 6) {
            sorteio.add(aleatorio.nextInt(60) + 1)
        }
            Log.i("semana03", sorteio.toString())

    }
}