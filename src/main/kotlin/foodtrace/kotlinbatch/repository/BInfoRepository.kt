package foodtrace.kotlinbatch.repository

import foodtrace.kotlinbatch.domain.BInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BInfoRepository : JpaRepository<BInfo, Long>