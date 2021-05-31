package com.stringconcat.tdd

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class WalletTest {
    @Test
    fun `wallet containing 2 USD is another wallet containing 2 USD`() {
        Wallet(Money.dollar(2)) shouldBe Wallet(Money.dollar(2))
    }

    @Test
    fun `wallet that contains 2 CHF returns 1 USD if rate 2 to 1`() {
        Wallet(Money.franc(2)).asDollars(2.0) shouldBe Money.dollar(1)
    }

    @Test
    fun `wallet that contains 3 CHF returns 1 USD if rate 3 to 1`() {
        Wallet(Money.franc(3)).asDollars(3.0) shouldBe Money.dollar(1)
    }

    @Test
    fun `wallet that contains 1 USD returns 2 CHF if rate 1 to 2`() {
        Wallet(Money.dollar(1)).asFranc(0.5) shouldBe Money.franc(2)
    }

    @Test
    fun `wallet that contains 2 CHF and 1 USD returns 2 USD if rate 2 to 1`() {
        Wallet(Money.franc(2), Money.dollar(1)).asDollars(2.0) shouldBe Money.dollar(2)
    }
}