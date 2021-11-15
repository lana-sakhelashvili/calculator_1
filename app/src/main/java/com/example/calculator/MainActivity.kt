package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var operand: Double = 0.0
    private var operation:String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)


    }

    fun numberClick(clickedView: View){
        if (clickedView is TextView){
            var result: String = resultTextView.text.toString()
            val number: String = clickedView.text.toString()

            if (result == "0"){
                result = ""
            }

            resultTextView.text = result + number
        }
    }

    fun operationClick(clickedView: View){
        if (clickedView is TextView){
            val result: String = resultTextView.text.toString()
            if(result.isNotEmpty()){
                this.operand = result.toDouble()

            }

            resultTextView.text = ""
            this.operation = clickedView.text.toString()
        }

    }

    fun equalsClick(clickedView: View) {
        var result: String = resultTextView.text.toString()
        var secoperand: Double = 0.0

        if(result.endsWith(".0")){
            result = result.dropLast(2)
            resultTextView.text = result
        }

        if (result.isNotEmpty()) {
            secoperand = result.toDouble()
        }

        when (operation) {
            "+" -> resultTextView.text = (operand + secoperand).toString()
            "-" -> resultTextView.text = (operand - secoperand).toString()
            "*" -> resultTextView.text = (operand * secoperand).toString()
            "/" -> resultTextView.text = (operand / secoperand).toString()

        }

    }

    fun clearClick(clickedView: View){
        val result: String = resultTextView.text.toString()

        if(result.isNotEmpty()){
            resultTextView.text = "0"

        }
    }

    fun deleteClick(clickedView: View){
        val result: String = resultTextView.text.toString()

        if(clickedView is TextView && result.isNotEmpty()){
            resultTextView.text = result.dropLast(1)

        }
    }

}