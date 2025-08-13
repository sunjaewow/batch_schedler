package foodtrace.kotlinbatch.provider

import foodtrace.kotlinbatch.dto.BProviderDto
import org.springframework.stereotype.Component

@Component
class BProvider : Provider<BProviderDto> {
    override fun fetchAll(): List<BProviderDto> =listOf(
        BProviderDto(1L, 2000L),
        BProviderDto(2L, 3000L)
    )
}
