package foodtrace.kotlinbatch.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
open class AInfo(
    @Id
    val id : Long,
    val name : String
) {
    protected constructor() : this(0L, "")
}