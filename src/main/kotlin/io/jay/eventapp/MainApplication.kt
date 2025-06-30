package io.jay.eventapp

import io.jay.eventapp.domain.Story
import io.jay.eventapp.dto.NewStoryRequest
import io.jay.eventapp.service.StoryService
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.runApplication
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@EnableAsync
@SpringBootApplication
class MainApplication

fun main(args: Array<String>) {
    runApplication<MainApplication>(*args)
}

@Component
class Runner(
    private val storyService: StoryService,
) : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun run(vararg args: String?) {
        storyService.create(NewStoryRequest(
            title = "CI/CD pipeline",
            description = "For acceptance environment"
        ))

        val stories = storyService.all()
        logger.info("{}", stories.map { it.id })
    }
}

@Component
class MyEventListener {

    private val logger = LoggerFactory.getLogger(javaClass)

    @EventListener
    fun handleApplicationReadyEvent(event: ApplicationReadyEvent) {
        logger.info("Application started: {}", event)
    }

    /* Version 1 */
//    @EventListener
//    fun handleStoryCreatedEvent(event: StoryCreatedEvent) {
//        logger.info("Story created: {}", event)
//    }

    /* Version 2 */
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    fun handleStoryCreatedEvent(event: StoryCreatedEvent) {
        logger.info("Story created: {}", event)
    }

    @Async
    @EventListener
    fun handleBadEvent(event: ErrorEvent) {
        logger.info("Story init: {}", event)
        throw RuntimeException("error event")
    }

}

data class StoryCreatedEvent(
    val story: Story
)

data class ErrorEvent(
    val story: Story
)