package com.beok.coroutinesflowtest

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ExchangeImpl : Exchange {

    override fun exchange(): Flow<Response> = flow {
        emit(Response(value = 1))
    }
}