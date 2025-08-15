package foodtrace.kotlinbatch.service

import foodtrace.kotlinbatch.dto.response.InfoResponseDto
import foodtrace.kotlinbatch.factory.ProviderFactory
import foodtrace.kotlinbatch.repository.AInfoRepository
import org.springframework.stereotype.Service

@Service
class BatchServiceImpl(
    private val providerFactory: ProviderFactory,
    private val aInfoRepository: AInfoRepository
) : BatchService {
    override fun fetchAllAndSave(key: Int){
        providerFactory.providerMap[key]?.fetchAndSave()
    }

    override fun batch(): List<InfoResponseDto> = aInfoRepository.join()
}
