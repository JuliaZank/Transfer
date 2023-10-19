fun main() {
    val commission = calculatePrice("VK Pay", 0, 100000)
    println(commission)
}

fun calculatePrice(typeCard: String, totalAmount: Int, amountTransfer: Int): String {
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
        "Mastercard" -> commissionMM
        "Maestro" -> commissionMM
        "Visa" -> commissionVM
        "Мир" -> commissionVM
        else -> commissionVK
    }
    return end
}

fun userTypeCard(typeCard: String) = when (typeCard) {
    "Mastercard" -> 0.6
    "Maestro" -> 0.6
    "Visa" -> 0.75
    "Мир" -> 0.75
    else -> 0.0
}