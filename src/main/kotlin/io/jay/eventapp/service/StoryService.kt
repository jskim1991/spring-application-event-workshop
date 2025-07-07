package io.jay.eventapp.service

import io.jay.eventapp.domain.Story
import io.jay.eventapp.repository.StoryRepository
import org.springframework.stereotype.Service

@Service
class StoryService(
    private val storyRepository: StoryRepository,
) {

    fun all(): List<Story> {
        return storyRepository.findAll().toList()
    }
}