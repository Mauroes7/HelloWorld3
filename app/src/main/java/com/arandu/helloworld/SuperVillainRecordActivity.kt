package com.arandu.helloworld

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class SuperVillainRecordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_super_villain_record)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val registerButton: Button = findViewById(R.id.register_button)
        val nameEditText: EditText = findViewById(R.id.name_editText)
        val infoTextView: TextView = findViewById(R.id.info_textView)
        val ageEditText: TextInputEditText = findViewById(R.id.age_edit_text)
        val masculinoRadioButton: RadioButton = findViewById(R.id.masculino_radioButton)

        registerButton.setOnClickListener {
            val name : String = nameEditText.text.toString()
            val age : Float = ageEditText.text.toString().toFloat()

            val gender: String = if (masculinoRadioButton.isChecked)
                getString(R.string.masculino)
            else
                getString(R.string.femenino)

            infoTextView.text = getString(R.string.info, name, age, gender)
        }
    }
}