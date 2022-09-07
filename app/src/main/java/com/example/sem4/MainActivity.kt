package com.example.sem4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var number: Int = 0
    lateinit var questions: ArrayList<Question>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadQuestion()
        setupBuild()
    }

    private fun loadQuestion() {
        questions= ArrayList()
        questions.add(Question("Es Lima la capital de Perú?",true))
        questions.add(Question("Es Lima la capital de Chile?",false))
        questions.add(Question("Es Lima la capital de Brasil?",false))
        questions.add(Question("Es Buenos Aires la capital de Brasil?",false))
        questions.add(Question("Es Bogota la capital de Colombia?",false))
    }

    private fun setupBuild(){
        val questionShow= findViewById<TextView>(R.id.tvQuestion)
        val btYes = findViewById<Button>(R.id.btSi)
        val btNo = findViewById<Button>(R.id.btNo)
        val btNext=findViewById<Button>(R.id.btNext)

        questionShow.text = questions[number].sentence

        btYes.setOnClickListener {
            if (questions[number].answer) {
                Toast.makeText(this,"Correcto",Toast.LENGTH_LONG).show()
            }
            else Toast.makeText(this,"Incorrecto",Toast.LENGTH_LONG).show()
        }

        btNo.setOnClickListener {
            if (questions[number].answer) {
                Toast.makeText(this,"Incorrecto",Toast.LENGTH_LONG).show()
            }
            else Toast.makeText(this,"Correcto",Toast.LENGTH_LONG).show()
        }

        btNext.setOnClickListener {
            number++
            if(number>questions.size) number = 0
            questionShow.text = questions[number].sentence
        }

    }
}