package foodtrace.kotlinbatch.service

import foodtrace.kotlinbatch.dto.Info
import foodtrace.kotlinbatch.dto.ProviderDto
import foodtrace.kotlinbatch.provider.Provider
import foodtrace.kotlinbatch.repository.AInfoRepository
import org.springframework.stereotype.Service

@Service
class FetchServiceImpl(
    providers : List<Provider<out ProviderDto>>,
    private val aInfoRepository: AInfoRepository
) : FetchService {
    private val providerMap =providers.associateBy { it.key}
    override fun fetchAllAndSave(key: Int){
        providerMap[key]?.fetchAndSave()
    }

    override fun batch(): List<Info> = aInfoRepository.join()
}
