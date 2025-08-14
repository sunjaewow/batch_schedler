package foodtrace.kotlinbatch.service

interface FetchService {
    fun fetchAllAndSave(key : Int)
    fun batch() : List<Info>
}