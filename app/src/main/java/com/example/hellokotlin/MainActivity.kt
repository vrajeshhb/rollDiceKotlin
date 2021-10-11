package com.example.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
var diceValue:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countUp:Button = findViewById(R.id.countUp)
        countUp.setOnClickListener{ countUpDice() }

        val reset: Button = findViewById(R.id.reset)
        reset.setOnClickListener { reset() }
    }

    private fun rollDice() {
        //Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
         diceValue= (1..6).random()
        updateDice(diceValue)


    }
    private fun countUpDice(){
       // var diceres = diceValue

        if(diceValue == 0){
            Toast.makeText(this, "Roll The Dice.", Toast.LENGTH_SHORT).show()
            updateDice(0)
        }else if(diceValue == 6){
            Toast.makeText(this, "Maxed Out!", Toast.LENGTH_SHORT).show()
            updateDice(6)
        }else{
            diceValue++
            //var n:Int = diceres.toInt()
            //n++
            //txtview.text = n.toString()
            updateDice(diceValue)
        }
    }
    private fun reset(){
        //val txtview: TextView = findViewById(R.id.rolltxt)
        //txtview.text = "0"
        diceValue = 0
        updateDice(0)
    }

    private fun updateDice(diceVal:Int){

        val diceImage: ImageView = findViewById(R.id.dice_image)
        val drawableResource = when (diceVal) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        diceImage.setImageResource(drawableResource)
    }


}