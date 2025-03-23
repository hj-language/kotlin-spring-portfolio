package com.hyejin.portfolio.admin.context.achievement.form

import com.hyejin.portfolio.domain.entity.Achievement
import jakarta.validation.constraints.NotBlank
import java.time.LocalDate

data class AchievementForm(
    @field:NotBlank(message = "필수값입니다.")
    val title: String,
    val description: String,
    val host: String,
    val achievedDate: String,
    val isActive: Boolean
) {
    fun toEntity(): Achievement {
        return Achievement(
            title = title,
            description = description,
            host = host,
            achievedDate = LocalDate.parse(achievedDate),
            isActive = isActive
        )
    }

    fun toEntity(id: Long): Achievement {
        val achievement = this.toEntity()
        achievement.id = id
        return achievement
    }
}