package br.com.wpaes.imc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class ResultActivity : AppCompatActivity() {

    companion object{
        const val BMI_RESULT = "bmi"
        const val BMI_CLASSIFICATION = "classification"
        const val BMI_OBESITY = "obesity"
        const val BMI_IMG = "image"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Create the Page with Data
        val result = intent.getDoubleExtra(BMI_RESULT, -1.0)
        val classification = intent.getStringExtra(BMI_CLASSIFICATION)
        val obesity = intent.getStringExtra(BMI_OBESITY)
        val img = intent.getIntExtra(BMI_IMG, -1)

        val txtResult = findViewById<TextView>(R.id.txtResult)
        val imgResult = findViewById<ImageView>(R.id.imgResult)

        txtResult.text = "IMC: ${"%.2f".format(result)} \nCLASSIFICAÇÃO: $classification \nGRAU DE OBESIDADE: $obesity"
        imgResult.contentDescription = classification
        imgResult.setImageResource(img)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
