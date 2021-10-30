package br.com.wpaes.imc

enum class BMIClassification(val classification: String, val obesity: String, val img: Int) {
    MAGREZA("Magreza", "0", R.drawable.abaixo_peso),
    NORMAL("Normal", "0", R.drawable.normal),
    SOBREPESO("Sobrepeso", "I", R.drawable.sobrepeso),
    OBESIDADE("Obesidade", "I", R.drawable.obesidade_1),
    OBESIDADE_2("Obesidade", "II", R.drawable.obesidade_2),
    OBESIDADE_GRAVE("Obesidade Grave", "III", R.drawable.obesidade_3)
}