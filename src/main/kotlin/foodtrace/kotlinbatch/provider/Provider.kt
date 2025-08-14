package foodtrace.kotlinbatch.provider

import foodtrace.kotlinbatch.dto.ProviderDto

interface Provider<T : ProviderDto> {
    val key : Int
    fun fetch() : List<T>
    fun fetchAndSave()
}