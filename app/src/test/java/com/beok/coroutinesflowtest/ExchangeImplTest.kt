package com.beok.coroutinesflowtest

import app.cash.turbine.test
import junit.framework.Assert.assertEquals
import kotlin.time.ExperimentalTime
import kotlinx.coroutines.runBlocking
import org.junit.Test

@ExperimentalTime
class ExchangeImplTest {

    private val exchange: Exchange = Exchange.Fake()

    @Test
    fun exchangeTest() = runBlocking {
        val mockResponse = Response(value = 0)

        exchange.exchange().test {
            assertEquals(mockResponse, expectItem())
            expectComplete()
        }
    }
}