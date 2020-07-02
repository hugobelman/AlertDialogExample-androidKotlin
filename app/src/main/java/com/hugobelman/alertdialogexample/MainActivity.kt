package com.hugobelman.alertdialogexample

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var entregada = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actualizarEntrega()

        entregar_btn.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Entregar tarea")
                setMessage("¿Estás seguro de entregar tu tarea al profesor? Esta acción es irreversible.")
                setPositiveButton("Si") { _: DialogInterface, _: Int ->
                    entregada = true
                    actualizarEntrega()
                }
                setNegativeButton("No", null)
            }.show()
        }
    }

    private fun actualizarEntrega() {
        if (entregada) {
            label_tv.text = "La tarea fue entregada"
            entregar_btn.text = "Entregada"
            entregar_btn.isEnabled = false
        } else {
            label_tv.text = "La tarea NO fue entregada"
            entregar_btn.text = "Entregar"
            entregar_btn.isEnabled = true
        }
    }
}