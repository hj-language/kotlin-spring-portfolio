package com.hyejin.portfolio.admin.context.project.service

import com.hyejin.portfolio.admin.data.TableDTO
import com.hyejin.portfolio.domain.repository.ProjectRepository
import com.hyejin.portfolio.domain.repository.SkillRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminProjectSkillService(
    private val projectRepository: ProjectRepository,
    private val skillRepository: SkillRepository,
) {
    @Transactional
    fun getProjectSkillTable(): TableDTO {
        val projects = projectRepository.findAll()
        val columns = mutableListOf<String>(
            "id", "projectId", "projectName",
            "skillId", "skillName",
            "createdDateTime", "updatedDateTime"
        )
        val records = mutableListOf<MutableList<String>>()
        for (project in projects) {
            project.skills.forEach {
                val record = mutableListOf(
                    it.id.toString(),
                    it.project.id.toString(),
                    it.project.name,
                    it.skill.id.toString(),
                    it.skill.name,
                    it.createdDateTime.toString(),
                    it.updatedDateTime.toString()
                )
                records.add(record)
            }
        }

        return TableDTO(name = "ProjectSkill", columns, records)
    }

    fun getProjectList(): List<String> {
        val projects = projectRepository.findAll()

        return projects.map { "${it.id} (${it.name})" }.toList()
    }

    fun getSkillList(): List<String> {
        val skills = skillRepository.findAll()

        return skills.map { "${it.id} (${it.name})" }.toList()
    }
}