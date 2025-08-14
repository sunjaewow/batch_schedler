package foodtrace.kotlinbatch.service

import foodtrace.kotlinbatch.dto.Info
import foodtrace.kotlinbatch.dto.ProviderDto
import foodtrace.kotlinbatch.provider.Provider
import org.springframework.stereotype.Service

@Service
class FetchServiceImpl(
    private val providers : List<Provider<out ProviderDto>>
) : FetchService {
    private val providerMap =providers.associateBy { it.key}
    override fun fetchAllAndSave(key: Int){
        providerMap[key]?.fetchAndSave()
    }

    override fun batch(): List<Info> {

    }
}
