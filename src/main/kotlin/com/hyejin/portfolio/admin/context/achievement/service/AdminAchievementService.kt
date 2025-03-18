package com.hyejin.portfolio.admin.context.achievement.service

import com.hyejin.portfolio.admin.data.TableDTO
import com.hyejin.portfolio.domain.entity.Achievement
import com.hyejin.portfolio.domain.repository.AchievementRepository
import org.springframework.stereotype.Service

@Service
class AdminAchievementService(
    private val achievementRepository: AchievementRepository
) {
    fun getAchievementTable(): TableDTO {
        return TableDTO.from(Achievement::class, achievementRepository.findAll())
    }
}