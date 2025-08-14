package foodtrace.kotlinbatch.repository

import foodtrace.kotlinbatch.domain.AInfo
import foodtrace.kotlinbatch.dto.Info
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AInfoRepository : JpaRepository<AInfo, Long> {
    @Query(
        value = """
        select a.id as id, a.name as name, b.price as price from AInfo a left join BInfo b on a.id = b.id
    """, nativeQuery = true)
    fun merge() : List<Info>
}