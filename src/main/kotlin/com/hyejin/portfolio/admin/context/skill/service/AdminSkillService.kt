package com.hyejin.portfolio.admin.context.skill.service

import com.hyejin.portfolio.admin.context.skill.form.SkillForm
import com.hyejin.portfolio.admin.data.TableDTO
import com.hyejin.portfolio.admin.exception.AdminBadRequestException
import com.hyejin.portfolio.domain.contant.SkillType
import com.hyejin.portfolio.domain.entity.Skill
import com.hyejin.portfolio.domain.repository.SkillRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminSkillService(
    private val skillRepository: SkillRepository
) {
    fun getSkillTable(): TableDTO {
        return TableDTO.from(Skill::class, skillRepository.findAll())
    }

    @Transactional
    fun save(form: SkillForm) {
        val skillType = SkillType.valueOf(form.type)
        skillRepository.findByNameIgnoreCaseAndType(form.name, skillType)
            .ifPresent { throw AdminBadRequestException("중복된 데이터입니다.") }

        skillRepository.save(form.toEntity())
    }

    @Transactional
    fun update(id: Long, form: SkillForm) {
        skillRepository.save(form.toEntity(id))
    }
}