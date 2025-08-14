package foodtrace.kotlinbatch.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
open class BInfo (
    @Id
    val id : Long,
    val price : Long
)