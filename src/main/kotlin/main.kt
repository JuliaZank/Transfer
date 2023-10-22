import java.time.Duration
import java.time.LocalDateTime
import java.util.*


fun main() {
    val dateStart = LocalDateTime.now()
    var totalAmount = 0
    val calendar: Calendar = Calendar.getInstance()
    val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

    while (true) {

        println("Введите сумму для перевода или введите 'end'")
        val amount = Scanner(System.`in`)
        val lineScanner = amount.nextLine()

        if (lineScanner == "end") {
            break
        }
        val dateFinish = LocalDateTime.now()
        val period = Duration.between(dateStart, dateFinish).toDays()
        totalAmount += lineScanner.toInt()

        if (period < daysInMonth && totalAmount > limit("VK Pay")) {
            println("Операция не может быть выполнена, так как был превышен лимит перевода денежных средств за один месяц")
        } else {
            val commission = calculatePrice("VK Pay", lineScanner.toInt())
            println(commission)
        }
    }
}

fun calculatePrice(typeCard: String, amountTransfer: Int): String {
    val total = userTypeCard(typeCard) * amountTransfer

    val commissionMM =
        if (amountTransfer > 150_000) {
            "Сумма перевода не должна превышать 150_000 рублей"
        } else if ((typeCard == "Mastercard" || typeCard == "Maestro") && amountTransfer < 75_000) {
            "Комиссия составит 0 рублей"
        } else "Комиссия составит ${total + 20} рублей"
    val commissionVM =
        if (amountTransfer > 150_000) {
            "Сумма перевода не должна превышать 150_000 рублей"
        } else if ((typeCard == "Visa" || typeCard == "Мир") && total < 35) {
            "Комиссия составит 35 рублей"
        } else "Комиссия составит $total рублей"
    val commissionVK =
        if (typeCard == "VK Pay" && amountTransfer > 15_000) "Сумма перевода не должна превышать 15_000 рублей" else "Комиссия составит $total рублей"

    val end = when (typeCard) {
        "Mastercard", "Maestro" -> commissionMM
        "Visa", "Мир" -> commissionVM
        else -> commissionVK
    }
    return end
}


fun userTypeCard(typeCard: String) = when (typeCard) {
    "Mastercard", "Maestro" -> 0.06
    "Visa", "Мир" -> 0.075
    else -> 0.0
}

fun limit(typeCard: String) = when (typeCard) {
    "Mastercard", "Maestro", "Visa", "Мир" -> 600_000
    else -> 40_000
}