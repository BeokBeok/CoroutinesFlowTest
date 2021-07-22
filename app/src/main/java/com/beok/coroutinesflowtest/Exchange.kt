package com.beok.coroutinesflowtest

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface Exchange {

    fun exchange(): Flow<Response>

    class Fake : Exchange {
        override fun exchange(): Flow<Response> = flow {
            emit(Response(value = 0))
        }
    }
}