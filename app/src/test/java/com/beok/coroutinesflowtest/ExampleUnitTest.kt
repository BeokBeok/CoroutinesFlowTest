package com.beok.coroutinesflowtest

import app.cash.turbine.test
import kotlin.time.ExperimentalTime
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@ExperimentalTime
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun consuming_event() = runBlocking {
        flowOf("one", "two").test {
            assertEquals("one", expectItem())
            assertEquals("two", expectItem())
            expectComplete()
        }
    }

    @Test
    fun consuming_event_ignore() = runBlocking {
        flowOf("one", "two").test {
            assertEquals("one", expectItem())
            cancelAndIgnoreRemainingEvents()
        }
    }
}