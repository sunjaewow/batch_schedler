package foodtrace.kotlinbatch.scheduler

import foodtrace.kotlinbatch.service.FetchService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class FetchScheduler(
    private val fetchService: FetchService
) {
    @Scheduled(cron = "0 0 1 * * *", zone = "Aisa/Seoul")
    fun fetchA() = fetchService.fetchAllAndSave(1)

    @Scheduled(cron = "0 0 2 * * *", zone = "Asia/Seoul")
    fun fetchB() = fetchService.fetchAllAndSave(2)
}
