package jp.techacademy.madoka.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var keisan = '+'
    var x: String? = null
    var y: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        kigou.setImageResource(R.drawable.tasu)

        tasu.setOnClickListener{
            kigou.setImageResource(R.drawable.tasu)
            keisan = '+'
        }
        hiku.setOnClickListener{
            kigou.setImageResource(R.drawable.hiku)
            keisan = '-'
            Log.d("test",keisan.toString())
        }
        kakeru.setOnClickListener{
            kigou.setImageResource(R.drawable.kakeru)
            keisan = '×'
        }
        waru.setOnClickListener{
            kigou.setImageResource(R.drawable.waru)
            keisan = '÷'
        }

        button1.setOnClickListener{

            x = edit1.text.toString()
            y = edit2.text.toString()
            val kigou = keisan.toString()

            if (x == "" || y ==""){
                val rootLayout: View = findViewById(android.R.id.content)
                val snackbar = Snackbar.make(rootLayout , "数値の入力は必須です", Snackbar.LENGTH_SHORT)
                snackbar.show()
            }else {

                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("keisan", kigou)
                intent.putExtra("text1", x)
                intent.putExtra("text2", y)
                startActivity(intent)
            }

        }
    }
}