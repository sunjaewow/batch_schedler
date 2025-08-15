package foodtrace.kotlinbatch.service

import foodtrace.kotlinbatch.dto.response.InfoResponseDto

interface BatchService {
    fun fetchAllAndSave(key : Int)
    fun batch() : List<InfoResponseDto>
}