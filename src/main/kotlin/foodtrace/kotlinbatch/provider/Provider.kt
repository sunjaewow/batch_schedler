package foodtrace.kotlinbatch.provider

import foodtrace.kotlinbatch.dto.request.ProviderDto

interface Provider<T : ProviderDto> {
    fun fetch() : List<T>
    fun fetchAndSave()
}