package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniciarOnCLickFuns()
    }

    fun iniciarOnCLickFuns() {
        val operaciones = OperacionesMatematicas()
        val tratamiento = TratamientoDelString(17)

        val button0 = findViewById<Button>(R.id.button0) as Button
        val button1 = findViewById<Button>(R.id.button1) as Button
        val button2 = findViewById<Button>(R.id.button2) as Button
        val button3 = findViewById<Button>(R.id.button3) as Button
        val button4 = findViewById<Button>(R.id.button4) as Button
        val button5 = findViewById<Button>(R.id.button5) as Button
        val button6 = findViewById<Button>(R.id.button6) as Button
        val button7 = findViewById<Button>(R.id.button7) as Button
        val button8 = findViewById<Button>(R.id.button8) as Button
        val button9 = findViewById<Button>(R.id.button9) as Button
        val buttonDel = findViewById<Button>(R.id.buttonDel) as Button
        val buttonDividido = findViewById<Button>(R.id.buttonDividido) as Button
        val buttonIgual = findViewById<Button>(R.id.buttonIgual) as Button
        val buttonMas = findViewById<Button>(R.id.buttonMas) as Button
        val buttonMenos = findViewById<Button>(R.id.buttonMenos) as Button
        val buttonPor = findViewById<Button>(R.id.buttonPor) as Button
        val buttonPunto = findViewById<Button>(R.id.buttonPunto) as Button

        val textoOperacion = findViewById<TextView>(R.id.textViewOperacion) as TextView
        val textoResultado = findViewById<TextView>(R.id.textViewResultado) as TextView

        button0.setOnClickListener {
            textoOperacion.text =
                tratamiento.addSymbolIfPossible('0', textoOperacion.text as String)
            textoResultado.text = operaciones.ejecutarOperacion(textoOperacion.text as String)
        }
        button1.setOnClickListener {
            textoOperacion.text =
                tratamiento.addSymbolIfPossible('1', textoOperacion.text as String)
            textoResultado.text = operaciones.ejecutarOperacion(textoOperacion.text as String)
        }
        button2.setOnClickListener {
            textoOperacion.text =
                tratamiento.addSymbolIfPossible('2', textoOperacion.text as String)
            textoResultado.text = operaciones.ejecutarOperacion(textoOperacion.text as String)
        }
        button3.setOnClickListener {
            textoOperacion.text =
                tratamiento.addSymbolIfPossible('3', textoOperacion.text as String)
            textoResultado.text = operaciones.ejecutarOperacion(textoOperacion.text as String)
        }
        button4.setOnClickListener {
            textoOperacion.text =
                tratamiento.addSymbolIfPossible('4', textoOperacion.text as String)
            textoResultado.text = operaciones.ejecutarOperacion(textoOperacion.text as String)
        }
        button5.setOnClickListener {
            textoOperacion.text =
                tratamiento.addSymbolIfPossible('5', textoOperacion.text as String)
            textoResultado.text = operaciones.ejecutarOperacion(textoOperacion.text as String)
        }
        button6.setOnClickListener {
            textoOperacion.text =
                tratamiento.addSymbolIfPossible('6', textoOperacion.text as String)
            textoResultado.text = operaciones.ejecutarOperacion(textoOperacion.text as String)
        }
        button7.setOnClickListener {
            textoOperacion.text =
                tratamiento.addSymbolIfPossible('7', textoOperacion.text as String)
            textoResultado.text = operaciones.ejecutarOperacion(textoOperacion.text as String)
        }
        button8.setOnClickListener {
            textoOperacion.text =
                tratamiento.addSymbolIfPossible('8', textoOperacion.text as String)
            textoResultado.text = operaciones.ejecutarOperacion(textoOperacion.text as String)
        }
        button9.setOnClickListener {
            textoOperacion.text =
                tratamiento.addSymbolIfPossible('9', textoOperacion.text as String)
            textoResultado.text = operaciones.ejecutarOperacion(textoOperacion.text as String)
        }
        buttonMas.setOnClickListener {
            textoOperacion.text =
                tratamiento.addSymbolIfPossible('+', textoOperacion.text as String)
            textoResultado.text = operaciones.ejecutarOperacion(textoOperacion.text as String)
        }
        buttonMenos.setOnClickListener {
            textoOperacion.text =
                tratamiento.addSymbolIfPossible('-', textoOperacion.text as String)
            textoResultado.text = operaciones.ejecutarOperacion(textoOperacion.text as String)
        }
        buttonPor.setOnClickListener {
            textoOperacion.text =
                tratamiento.addSymbolIfPossible('x', textoOperacion.text as String)
            textoResultado.text = operaciones.ejecutarOperacion(textoOperacion.text as String)
        }
        buttonDividido.setOnClickListener {
            textoOperacion.text =
                tratamiento.addSymbolIfPossible('/', textoOperacion.text as String)
            textoResultado.text = operaciones.ejecutarOperacion(textoOperacion.text as String)
        }
        buttonPunto.setOnClickListener {
            textoOperacion.text =
                tratamiento.addSymbolIfPossible('.', textoOperacion.text as String)
            textoResultado.text = operaciones.ejecutarOperacion(textoOperacion.text as String)
        }
        buttonDel.setOnClickListener {
            if (textoOperacion.text.isNotEmpty()) {
                textoOperacion.text = textoOperacion.text.take(textoOperacion.text.length - 1)
            }
            textoResultado.text = operaciones.ejecutarOperacion(textoOperacion.text as String)
        }
        buttonDel.setOnLongClickListener {
            textoOperacion.text = ""
            textoResultado.text = ""
            return@setOnLongClickListener true
        }
        buttonIgual.setOnClickListener {
            if (textoResultado.text != "") {
                textoOperacion.text =
                    if (BigDecimal(textoResultado.text.toString().toDouble()).setScale(
                            5,
                            RoundingMode.HALF_EVEN
                        ).toDouble().mod(1.0) == 0.0
                    ) {
                        BigDecimal(textoResultado.text.toString().toDouble()).setScale(
                            5,
                            RoundingMode.HALF_EVEN
                        ).toDouble().toLong().toString()
                    } else {
                        BigDecimal(textoResultado.text.toString().toDouble()).setScale(
                            5,
                            RoundingMode.HALF_EVEN
                        ).toDouble().toString()
                    }
                textoResultado.text = ""
            }

        }
    }
}