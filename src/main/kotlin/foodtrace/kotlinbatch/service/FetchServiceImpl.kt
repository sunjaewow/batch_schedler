package foodtrace.kotlinbatch.service

import foodtrace.kotlinbatch.domain.AInfo
import foodtrace.kotlinbatch.dto.AProviderDto
import foodtrace.kotlinbatch.dto.BProviderDto
import foodtrace.kotlinbatch.provider.Provider
import foodtrace.kotlinbatch.repository.AInfoRepository
import foodtrace.kotlinbatch.repository.BInfoRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class FetchServiceImpl(
    private val aProvider: Provider<AProviderDto>,
    private val bProvider: Provider<BProviderDto>,
    private val aInfoRepository: AInfoRepository,
    private val bInfoRepository : BInfoRepository
) : FetchService {

    @Transactional
    override fun AfetchAllAndSave() {
        val aProviderDtos = aProvider.fetchAll()
        aInfoRepository.saveAll(aProviderDtos.map { AInfo(it.id, it.name) })
    }

    @Transactional


}