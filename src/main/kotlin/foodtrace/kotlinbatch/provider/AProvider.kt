package foodtrace.kotlinbatch.provider

import foodtrace.kotlinbatch.domain.AInfo
import foodtrace.kotlinbatch.dto.AProviderDto
import foodtrace.kotlinbatch.repository.AInfoRepository
import org.springframework.stereotype.Service

@Service
class AProvider(
    private val aInfoRepository: AInfoRepository,
    override val key: Int =1
) : Provider<AProviderDto> {
    override fun fetch(): List<AProviderDto> = listOf(
        AProviderDto(1L, "good"),
        AProviderDto(2L, "good2")
    )

    override fun fetchAndSave() {
        aInfoRepository.saveAll(fetch().map { AInfo(it.id, it.name) })
    }
}
