package foodtrace.kotlinbatch.provider

import foodtrace.kotlinbatch.domain.BInfo
import foodtrace.kotlinbatch.dto.BProviderDto
import foodtrace.kotlinbatch.repository.BInfoRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class BProvider(
    private val bInfoRepository: BInfoRepository,
    private val webClient : WebClient
) : Provider<BProviderDto> {
    override val key: Int=2

    override fun fetch(): List<BProviderDto> {
        return webClient.get()
            .uri("https://api.example.com/a/infos")
            .retrieve()
            .bodyToFlux(BProviderDto::class.java)
            .collectList()
            .block()!!
    }

    override fun fetchAndSave() {
        bInfoRepository.saveAll(fetch().map { BInfo(it.id, it.price) })
    }
}
