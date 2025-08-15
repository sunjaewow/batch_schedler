package foodtrace.kotlinbatch

import foodtrace.kotlinbatch.repository.AInfoRepository
import foodtrace.kotlinbatch.service.FetchServiceImpl
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class ServiceTest {
    @InjectMocks
    lateinit var service : FetchServiceImpl
    @Mock
    lateinit var aInfoRepository: AInfoRepository

}