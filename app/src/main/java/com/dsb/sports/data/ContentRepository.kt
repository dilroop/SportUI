package com.dsb.sports.data

import com.dsb.sports.models.Sport
import kotlinx.coroutines.delay

class ContentRepository {
    suspend fun getFeaturedSports(): List<Sport> {
        delay(5000)
        return Sport.createMockedSports()
    }
}
