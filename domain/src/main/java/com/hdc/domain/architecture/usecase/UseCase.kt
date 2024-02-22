package com.hdc.domain.architecture.usecase

interface UseCase<REQUEST, RESPONSE> {
    suspend fun execute(input: REQUEST, onResult:(RESPONSE)->Unit)
}