package foodtrace.kotlinbatch.factory

import foodtrace.kotlinbatch.dto.request.ProviderDto
import foodtrace.kotlinbatch.provider.AProvider
import foodtrace.kotlinbatch.provider.BProvider
import foodtrace.kotlinbatch.provider.Provider
import org.springframework.stereotype.Component

@Component
class ProviderFactory(
    private val aProvider: AProvider,
    private val bProvider: BProvider
) {

    val providerMap : Map<Int, Provider<out ProviderDto>> = mapOf(
        1 to aProvider,
        2 to bProvider
    )
}