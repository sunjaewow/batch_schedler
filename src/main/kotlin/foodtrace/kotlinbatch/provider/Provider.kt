package foodtrace.kotlinbatch.provider

import foodtrace.kotlinbatch.dto.ProviderDto

interface Provider<T : ProviderDto> {
    fun fetchAll() : List<T>
}