package foodtrace.kotlinbatch.provider

import foodtrace.kotlinbatch.domain.BInfo
import foodtrace.kotlinbatch.dto.BProviderDto
import foodtrace.kotlinbatch.repository.BInfoRepository
import org.springframework.stereotype.Component

@Component
class BProvider(
    private val bInfoRepository: BInfoRepository
) : Provider<BProviderDto> {
    override val key: Int=2

    override fun fetch(): List<BProviderDto> =listOf(
        BProviderDto(1L, 2000L),
        BProviderDto(2L, 3000L)
    )

    override fun fetchAndSave() {
        bInfoRepository.saveAll(fetch().map { BInfo(it.id, it.price) })
    }
}
