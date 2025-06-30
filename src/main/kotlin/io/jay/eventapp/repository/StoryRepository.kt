package io.jay.eventapp.repository

import io.jay.eventapp.domain.Story
import org.springframework.data.repository.CrudRepository

interface StoryRepository : CrudRepository<Story, Long> {
    fun id(id: Long): MutableList<Story>

}
