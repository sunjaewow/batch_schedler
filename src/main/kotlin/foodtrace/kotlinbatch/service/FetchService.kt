package foodtrace.kotlinbatch.service

import foodtrace.kotlinbatch.dto.Info

interface FetchService {
    fun fetchAllAndSave(key : Int)
    fun batch() : List<Info>
}