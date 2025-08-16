package foodtrace.kotlinbatch.provider

import foodtrace.kotlinbatch.domain.AInfo
import foodtrace.kotlinbatch.dto.request.AProviderDto
import foodtrace.kotlinbatch.repository.AInfoRepository
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class AProvider(
    private val aInfoRepository: AInfoRepository,
    private val webClient : WebClient
) : Provider<AProviderDto> {

    override fun fetch(): List<AProviderDto> {
        return webClient.get()
            .uri("https://api.example.com/a/infos")
            .retrieve()
            .bodyToFlux(AProviderDto::class.java)
            .collectList()
            .block()!!
    }

    override fun fetchAndSave() {
        aInfoRepository.saveAll(fetch().map { AInfo(it.id, it.name) })
    }
}
