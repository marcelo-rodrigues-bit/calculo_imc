package br.com.wpaes.imc

import java.util.*
import kotlin.math.pow

class BMI(var height: Double, var weight: Double) {

    var result: Double = 0.00
    var classification: String = ""
    var obesity: String = ""
    var img: Int = 0

    init {
        this.calculate()
        this.setClassificationAndObesity()
    }

    fun calculate() {
        this.result = weight / height.pow(2.0)
    }

    fun setClassificationAndObesity() {
        if (result < 18.5) {

            classification = BMIClassification.MAGREZA.classification
            obesity = BMIClassification.MAGREZA.obesity
            img = BMIClassification.MAGREZA.img

        } else if (result > 18.5 && result <= 24.9) {

            classification = BMIClassification.NORMAL.classification
            obesity = BMIClassification.NORMAL.obesity
            img = BMIClassification.NORMAL.img

        } else if (result > 24.9 && result <= 29.9) {

            classification = BMIClassification.SOBREPESO.classification
            obesity = BMIClassification.SOBREPESO.obesity
            img = BMIClassification.SOBREPESO.img

        } else if (result > 29.9 && result <= 34.9) {

            classification = BMIClassification.OBESIDADE.classification
            obesity = BMIClassification.OBESIDADE.obesity
            img = BMIClassification.OBESIDADE.img

        } else if (result > 34.9 && result <= 39.9) {

            classification = BMIClassification.OBESIDADE_2.classification
            obesity = BMIClassification.OBESIDADE_2.obesity
            img = BMIClassification.OBESIDADE_2.img

        } else {

            classification = BMIClassification.OBESIDADE_GRAVE.classification
            obesity = BMIClassification.OBESIDADE_GRAVE.obesity
            img = BMIClassification.OBESIDADE_GRAVE.img

        }
    }
}