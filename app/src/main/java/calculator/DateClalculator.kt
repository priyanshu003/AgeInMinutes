package calculator

import java.text.SimpleDateFormat
import java.util.*

class DateCalculator{
    private val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
    val today = sdf.parse(sdf.format(System.currentTimeMillis()))
    fun calculateAgeInMinutes(selectedDate: String): String {
        val selectedDate = sdf.parse(selectedDate)
        val inMinutes = (today.time / 60000) - (selectedDate.time / 60000)
        return "$inMinutes"

    }

}