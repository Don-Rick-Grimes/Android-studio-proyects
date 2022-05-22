package com.example.helloandroidstudio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // variablesYConstantes()

        val helloText = findViewById<TextView>(R.id.textView) as TextView
        val mySwitch = findViewById<Switch>(R.id.switch2) as Switch
        val unEditText = findViewById<EditText>(R.id.editTextTextPersonName) as EditText

        helloText.setOnClickListener {
            helloText.text = "Otro texto"
            Toast.makeText(this@MainActivity,"Hello Kotlin",Toast.LENGTH_SHORT).show()
        }
        mySwitch.setOnClickListener {
            if (mySwitch.isChecked){
                helloText.text = "Hola Mundo"
                Toast.makeText(this@MainActivity,"Switch ON",Toast.LENGTH_SHORT).show()
            }
            else{
                helloText.text= "Hello World"
                Toast.makeText(this@MainActivity,"Switch OFF",Toast.LENGTH_SHORT).show()
            }
        }


    }






    private fun variablesYConstantes() {
        //Variables
        var myFirstVariable = "Hello Hackermen"
        println(myFirstVariable)
        val numero: Byte = 100
        // If
        if (numero <= 200) {
            println("$numero es menor o igual que 200")
        }
        // Setencia When
        val country = "Usa"
        when (country) {
            "Colombia" -> {
                println("El idioma es paisa")
            }
            "Usa" -> {
                println("El idioma es ingles")
            }

        }
        // Array
        var myArray = arrayListOf<String>()
        myArray.add(country)
        myArray.add("Cosa")
        myArray.add("$numero")
        println(myArray)

        myArray.addAll(listOf("Hola", "Bienvenidos al tutorial"))
        println(myArray)
        println(myArray[0])
        myArray.removeAt(3)
        println(myArray)

        myArray.forEach {
            println(it)
        }
        println(myArray.size)

        // map - mapa o diccionario mapof-mutablemapof

        // For(X in ArraY), for(x in 0..10) - (.., until, downto) step
        //While



        // Null Safety      String?  -> String nulable
        // println(mySafetyString?.length)  <-
        // if(myString != null){
        // println(mySafetyString!!)
        //}
        //mySafetyString?.let{
        //    println(it)
        //}?: run{
        //    println(mySafetyString)
        // }

    }
}