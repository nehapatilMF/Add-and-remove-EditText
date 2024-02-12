package com.example.oncliickaddedittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var linearLayout: LinearLayout
    private var editTextCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayout = findViewById(R.id.lL)
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            addEditText()
        }
        val btn1 = findViewById<Button>(R.id.button1)
        btn1.setOnClickListener {
            removeEditText()
        }
    }
    private fun addEditText() {
        val newEditText = EditText(this)
        newEditText.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        linearLayout.addView(newEditText)
        editTextCount++
        Toast.makeText(this,"$editTextCount",Toast.LENGTH_SHORT).show()
    }

    private fun removeEditText(){
        if(editTextCount > 0){
            linearLayout.removeViewAt(linearLayout.childCount - 1)
            editTextCount--
            Toast.makeText(this, "Removed last EditText", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "No EditText to remove", Toast.LENGTH_SHORT).show()
        }
    }

}