package io.jay.eventapp.service

import io.jay.eventapp.StoryCreatedEvent
import io.jay.eventapp.ErrorEvent
import io.jay.eventapp.domain.Story
import io.jay.eventapp.dto.NewStoryRequest
import io.jay.eventapp.repository.StoryRepository
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StoryService(
    private val storyRepository: StoryRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    @Transactional
    fun create(newStoryRequest: NewStoryRequest): Story {
        logger.info("Creating a new story")
        val saved = storyRepository.save(
            Story(
                id = 0L,
                title = newStoryRequest.title,
                description = newStoryRequest.description
            )
        )
//        applicationEventPublisher.publishEvent(ErrorEvent(saved))
        applicationEventPublisher.publishEvent(StoryCreatedEvent(saved))
        logger.info("Returning saved story: {}", saved)
        return saved
    }

    fun all(): List<Story> {
        return storyRepository.findAll().toList()
    }
}