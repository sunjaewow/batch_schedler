package foodtrace.kotlinbatch.provider

import foodtrace.kotlinbatch.dto.AProviderDto
import org.springframework.stereotype.Component

@Component
class AProvider : Provider<AProviderDto> {
    override fun fetchAll(): List<AProviderDto> = listOf(
        AProviderDto(1L, "good"),
        AProviderDto(2L, "good2")
    )
}