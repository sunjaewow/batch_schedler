package foodtrace.kotlinbatch.service

import foodtrace.kotlinbatch.dto.Info
import foodtrace.kotlinbatch.factory.ProviderFactory
import foodtrace.kotlinbatch.repository.AInfoRepository
import org.springframework.stereotype.Service

@Service
class FetchServiceImpl(
    private val providerFactory: ProviderFactory,
    private val aInfoRepository: AInfoRepository
) : FetchService {
    override fun fetchAllAndSave(key: Int){
        providerFactory.providerMap[key]?.fetchAndSave()
    }

    override fun batch(): List<Info> = aInfoRepository.join()
}
