import org.junit.Test

import org.junit.Assert.*
class MainKtTest {
    @Test
    fun calculatePriceVisa() {
        val typeCard = "Visa"
        val amountTransfer = 100_000
        val amountPreviousTransfers = 0
        val result = calculatePrice(typeCard, amountPreviousTransfers, amountTransfer)

        assertEquals("Комиссия составит 750.0 рублей", result)
    }

    @Test
    fun calculatePriceMir() {
        val typeCard = "Мир"
        val amountTransfer = 100_000
        val amountPreviousTransfers = 0
        val result = calculatePrice(typeCard, amountPreviousTransfers, amountTransfer)

        assertEquals("Комиссия составит 750.0 рублей", result)
    }

    @Test
    fun calculatePriceMaestro() {
        val typeCard = "Maestro"
        val amountTransfer = 100_000
        val amountPreviousTransfers = 0
        val result = calculatePrice(typeCard, amountPreviousTransfers, amountTransfer)

        assertEquals("Комиссия составит 620.0 рублей", result)
    }

    @Test
    fun calculatePriceMastercard() {
        val typeCard = "Mastercard"
        val amountTransfer = 100_000
        val amountPreviousTransfers = 0
        val result = calculatePrice(typeCard, amountPreviousTransfers, amountTransfer)

        assertEquals("Комиссия составит 620.0 рублей", result)
    }

    @Test
    fun calculatePriceVKPay() {
        val typeCard = "VK Pay"
        val amountTransfer = 10_000
        val amountPreviousTransfers = 0
        val result = calculatePrice(typeCard, amountPreviousTransfers, amountTransfer)

        assertEquals("Комиссия составит 0.0 рублей", result)
    }

    @Test
    fun calculatePriceLimitVisa() {
        var typeCard = "Visa"
        val amountTransfer = 200_000
        val amountPreviousTransfers = 550_000
        val result = calculatePrice(typeCard, amountPreviousTransfers, amountTransfer)
        if (amountTransfer > 150_000 || amountTransfer + amountPreviousTransfers > 600_000) {
            "Превышен лимит"
        } else {
            result
        }
        assertEquals("Превышен лимит", result)
    }

    @Test
    fun calculatePriceLimitVisaMonth() {
        var typeCard = "Visa"
        val amountTransfer = 100_000
        val amountPreviousTransfers = 550_000
        val result = calculatePrice(typeCard, amountPreviousTransfers, amountTransfer)
        if (amountTransfer > 150_000 || amountTransfer + amountPreviousTransfers > 600_000) {
            "Превышен лимит"
        } else {
            result
        }
        assertEquals("Превышен лимит", result)
    }

    @Test
    fun calculatePriceLimitMir() {
        var typeCard = "Мир"
        val amountTransfer = 200_000
        val amountPreviousTransfers = 550_000
        val result = calculatePrice(typeCard, amountPreviousTransfers, amountTransfer)
        if (amountTransfer > 150_000 || amountTransfer + amountPreviousTransfers > 600_000) {
            "Превышен лимит"
        } else {
            result
        }
        assertEquals("Превышен лимит", result)
    }

    @Test
    fun calculatePriceLimitMirMonth() {
        var typeCard = "Мир"
        val amountTransfer = 100_000
        val amountPreviousTransfers = 550_000
        val result = calculatePrice(typeCard, amountPreviousTransfers, amountTransfer)
        if (amountTransfer > 150_000 || amountTransfer + amountPreviousTransfers > 600_000) {
            "Превышен лимит"
        } else {
            result
        }
        assertEquals("Превышен лимит", result)
    }

    @Test
    fun calculatePriceLimitMastercard() {
        var typeCard = "Mastercard"
        val amountTransfer = 200_000
        val amountPreviousTransfers = 550_000
        val result = calculatePrice(typeCard, amountPreviousTransfers, amountTransfer)
        if (amountTransfer > 150_000 || amountTransfer + amountPreviousTransfers > 600_000) {
            "Превышен лимит"
        } else {
            result
        }
        assertEquals("Превышен лимит", result)
    }

    @Test
    fun calculatePriceLimitMastercardMonth() {
        var typeCard = "Mastercard"
        val amountTransfer = 100_000
        val amountPreviousTransfers = 550_000
        val result = calculatePrice(typeCard, amountPreviousTransfers, amountTransfer)
        if (amountTransfer > 150_000 || amountTransfer + amountPreviousTransfers > 600_000) {
            "Превышен лимит"
        } else {
            result
        }
        assertEquals("Превышен лимит", result)
    }

    @Test
    fun calculatePriceLimitMaestro() {
        val typeCard = "Maestro"
        val amountTransfer = 200_000
        val amountPreviousTransfers = 550_000
        val result = calculatePrice(typeCard, amountPreviousTransfers, amountTransfer)
        if (amountTransfer > 150_000 || amountTransfer + amountPreviousTransfers > 600_000) {
            "Превышен лимит"
        } else {
            result
        }
        assertEquals("Превышен лимит", result)
    }

    @Test
    fun calculatePriceLimitMaestroMonth() {
        val typeCard = "Maestro"
        val amountTransfer = 100_000
        val amountPreviousTransfers = 550_000
        val result = calculatePrice(typeCard, amountPreviousTransfers, amountTransfer)
        if (amountTransfer > 150_000 || amountTransfer + amountPreviousTransfers > 600_000) {
            "Превышен лимит"
        } else {
            result
        }
        assertEquals("Превышен лимит", result)
    }

    @Test
    fun calculatePriceLimitVKPay() {
        val typeCard = "VK Pay"
        val amountTransfer = 10_000
        val amountPreviousTransfers = 35_000
        val result = calculatePrice(typeCard, amountPreviousTransfers, amountTransfer)
        if (amountTransfer > 15_000 || amountTransfer + amountPreviousTransfers > 40_000) {
            "Превышен лимит"
        } else {
            result
        }
        assertEquals("Превышен лимит", result)
    }

    @Test
    fun calculatePriceMaestroNotCommission() {
        val typeCard = "Maestro"
        val amountTransfer = 60_000
        val amountPreviousTransfers = 0
        val result = calculatePrice(typeCard, amountPreviousTransfers, amountTransfer)

        assertEquals("Комиссия составит 0 рублей", result)
    }

    @Test
    fun calculatePriceMastercardNotCommission() {
        val typeCard = "Maestro"
        val amountTransfer = 60_000
        val amountPreviousTransfers = 0
        val result = calculatePrice(typeCard, amountPreviousTransfers, amountTransfer)

        assertEquals("Комиссия составит 0 рублей", result)
    }

    @Test
    fun calculatePriceVisaMinCommission() {
        val typeCard = "Visa"
        val amountTransfer = 600
        val amountPreviousTransfers = 0
        val result = calculatePrice(typeCard, amountPreviousTransfers, amountTransfer)

        assertEquals("Комиссия составит 35 рублей", result)
    }

    @Test
    fun calculatePriceMirMinCommission() {
        val typeCard = "Мир"
        val amountTransfer = 600
        val amountPreviousTransfers = 0
        val result = calculatePrice(typeCard, amountPreviousTransfers, amountTransfer)

        assertEquals("Комиссия составит 35 рублей", result)
    }

    @Test
    fun main() {
        val result = calculatePrice(amountTransfer = 650_000)

        assertEquals("Превышен лимит", result)
    }
}