package com.ivan.firstapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val b = findViewById<Button>(R.id.button)

        // Esquema de cómo sería usando explícitamente un View.OnClickListener
        /* b.setOnClickListener(View.OnClickListener() {
            fun onClick
        }) */
        // PARA EVITAR ESCRIBIR ESO:
        // Usamos una lambda para indicar que debe ocurrir cuando se pulsa el boton.
        // setOnClickListener espera una acción y Kotlin permite escribirla de forma
        // más corta sin tener que crear manualmente un objeto View.OnClickListener.
        b.setOnClickListener {
            val text = "Soy Iván y este es mi primer botón!"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(this, text, duration)
            toast.show()

        }

    }
}