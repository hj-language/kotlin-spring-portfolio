package com.hyejin.portfolio.admin.context.achievement.service

import com.hyejin.portfolio.admin.data.TableDTO
import com.hyejin.portfolio.admin.exception.AdminBadRequestException
import com.hyejin.portfolio.domain.entity.Experience
import com.hyejin.portfolio.domain.entity.ExperienceDetail
import com.hyejin.portfolio.domain.repository.ExperienceRepository
import org.springframework.stereotype.Service

@Service
class AdminExperienceService(
    private val experienceRepository: ExperienceRepository
) {
    fun getExperienceTable(): TableDTO {
        return TableDTO.from(Experience::class, experienceRepository.findAll(), "details")
    }

    fun getExperienceTable(id: Long?): TableDTO {
        val entities = if (id != null)
            experienceRepository.findById(id)
                .orElseThrow { throw AdminBadRequestException("ID ${id}에 해당하는 데이터를 찾을 수 없습니다.") }
                .details
        else emptyList()

        return TableDTO.from(ExperienceDetail::class, entities)
    }
}