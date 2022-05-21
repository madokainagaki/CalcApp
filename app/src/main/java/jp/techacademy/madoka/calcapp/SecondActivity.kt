package jp.techacademy.madoka.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_second2.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second2)

        val keisan1 = intent.getStringExtra("keisan")
        val value1 = intent.getStringExtra("text1")
        val value2 = intent.getStringExtra("text2")

        textView1.text = value1
        textView2.text = value2
        textView3.text = keisan1

        val x = value1.toString().toFloat()
        val y = value2.toString().toFloat()

        val result = when(keisan1){
            "+" -> x + y
            "-" -> x - y
            "×" -> x * y
            else -> x / y
        }

        resultView.text = "= ${result}"

        button2.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}