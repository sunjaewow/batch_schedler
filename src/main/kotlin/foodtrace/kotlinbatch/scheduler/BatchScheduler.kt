package foodtrace.kotlinbatch.scheduler

import foodtrace.kotlinbatch.service.BatchService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class BatchScheduler(
    private val batchService: BatchService
) {
    @Scheduled(cron = "0 0 1 * * *", zone = "Aisa/Seoul")
    fun fetchA() = batchService.fetchAllAndSave(1)

    @Scheduled(cron = "0 0 2 * * *", zone = "Asia/Seoul")
    fun fetchB() = batchService.fetchAllAndSave(2)

    @Scheduled(cron = "0 0 3 * * *", zone = "Asia/Seoul")
    fun batch()=batchService.batch()
}
