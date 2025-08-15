package foodtrace.kotlinbatch

import foodtrace.kotlinbatch.domain.AInfo
import foodtrace.kotlinbatch.domain.BInfo
import foodtrace.kotlinbatch.dto.Info
import foodtrace.kotlinbatch.repository.AInfoRepository
import foodtrace.kotlinbatch.repository.BInfoRepository
import foodtrace.kotlinbatch.service.FetchService
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.Test
import kotlin.test.assertEquals

@SpringBootTest
class ServiceTest(
    @Autowired
    private val fetchService: FetchService,
    @Autowired
    private val aInfoRepository: AInfoRepository,
    @Autowired
    private val bInfoRepository: BInfoRepository
){
    @AfterEach
    fun clean() {
        aInfoRepository.deleteAll()
        bInfoRepository.deleteAll()
    }

    //id가 다를 수도?
    @Test
    @DisplayName("batch_성공")
    fun test1() {
        //given
        aInfoRepository.saveAll(listOf(
            AInfo(1L, "a"),
            AInfo(2L, "b")
        ))

        bInfoRepository.saveAll(listOf(
            BInfo(1L, 2000L),
            BInfo(2L, 3000L),
            BInfo(4L, 3000L),
        ))

        //when
        val result = fetchService.batch()
        val expected = listOf(
            Info(1L, "a", 2000L),
            Info(2L, "b", 3000L)
        )
        //then
        assertEquals(expected, result.sortedBy { it.id })
    }
}