package com.hyejin.portfolio.admin.context.skill.service

import com.hyejin.portfolio.admin.data.TableDTO
import com.hyejin.portfolio.domain.entity.Skill
import com.hyejin.portfolio.domain.repository.SkillRepository
import org.springframework.stereotype.Service

@Service
class AdminSkillService(
    private val skillRepository: SkillRepository
) {
    fun getSkillTable(): TableDTO {
        return TableDTO.from(Skill::class, skillRepository.findAll())
    }
}