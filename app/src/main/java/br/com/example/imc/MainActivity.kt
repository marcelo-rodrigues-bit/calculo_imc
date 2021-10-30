package br.com.wpaes.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var txtHeight: TextView? = null
    private var txtWeight: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnClear = findViewById<Button>(R.id.btnClear)

        this.txtHeight = findViewById(R.id.txtHeight)
        this.txtWeight = findViewById(R.id.txtWeight)

        btnCalculate.setOnClickListener {
            val height = txtHeight?.text.toString()
            val weight = txtWeight?.text.toString()

            // Check if the fields are not null
            if (height.isEmpty() || weight.isEmpty()) {
                Toast.makeText(this, "Fill correctly the fields", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            // Instantiate the BMI class and call Calculate and Classification methods in Constructor
            val bmi = BMI(height.toDouble(), weight.toDouble())

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(ResultActivity.BMI_RESULT, bmi.result)
            intent.putExtra(ResultActivity.BMI_CLASSIFICATION, bmi.classification)
            intent.putExtra(ResultActivity.BMI_OBESITY, bmi.obesity)
            intent.putExtra(ResultActivity.BMI_IMG, bmi.img)
            startActivity(intent)
        }

        btnClear.setOnClickListener {
            txtHeight?.text = ""
            txtWeight?.text = ""
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putCharSequence("HEIGHT", this.txtHeight?.text)
        outState.putCharSequence("WEIGHT", this.txtWeight?.text)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        this.txtHeight?.text = savedInstanceState.getCharSequence("HEIGHT")
        this.txtWeight?.text = savedInstanceState.getCharSequence("WEIGHT")
    }
}
