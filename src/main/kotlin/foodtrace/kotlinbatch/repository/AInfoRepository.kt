package foodtrace.kotlinbatch.repository

import foodtrace.kotlinbatch.domain.AInfo
import foodtrace.kotlinbatch.dto.response.InfoResponseDto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AInfoRepository : JpaRepository<AInfo, Long> {
    @Query(
        "select new foodtrace.kotlinbatch.dto.response.InfoResponseDto(a.id, a.name, b.price) from AInfo a left join BInfo b on a.id=b.id"
    )
    fun join() : List<InfoResponseDto>
}