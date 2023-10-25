fun main() {
   val commission = calculatePrice("VK Pay", 0, 100000)
            println(commission)
}

fun calculatePrice(typeCard: String, amountPreviousTransfers: Int, amountTransfer: Int): String {
    val total = userTypeCard(typeCard) * amountTransfer

    return when(typeCard) {
        "Mastercard", "Maestro" -> if (amountTransfer < 75_000 && amountTransfer + amountPreviousTransfers <= 600_000) {
            "Комиссия составит 0 рублей"
        } else if (amountTransfer in 75_000..150_000 && amountTransfer + amountPreviousTransfers <= 600_000) {
            "Комиссия составит ${total + 20} рублей"
        } else "Превышен лимит"

        "Visa", "Мир" -> if (amountTransfer <= 150_000 && total < 35 && amountTransfer + amountPreviousTransfers <= 600_000) {
            "Комиссия составит 35 рублей"
        } else if (amountTransfer <= 150_000 && amountTransfer + amountPreviousTransfers <= 600_000) {
            "Комиссия составит $total рублей"
        } else "Превышен лимит"
        else -> if (amountTransfer <= 15_000 && amountTransfer + amountPreviousTransfers <= 40_000) "Комиссия составит $total рублей" else "Превышен лимит"
    }
}


fun userTypeCard(typeCard: String) = when (typeCard) {
    "Mastercard", "Maestro" -> 0.006
    "Visa", "Мир" -> 0.0075
    else -> 0.0
}