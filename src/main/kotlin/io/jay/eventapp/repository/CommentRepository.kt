package io.jay.eventapp.repository

import io.jay.eventapp.domain.Comment
import org.springframework.data.repository.CrudRepository

interface CommentRepository : CrudRepository<Comment, Long> {
    fun findAllByStoryIdIn(storyIds: List<Long>): List<Comment>
}