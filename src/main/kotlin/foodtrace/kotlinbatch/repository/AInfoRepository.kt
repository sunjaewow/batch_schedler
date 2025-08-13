package foodtrace.kotlinbatch.repository

import foodtrace.kotlinbatch.domain.AInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AInfoRepository : JpaRepository<AInfo, Long>