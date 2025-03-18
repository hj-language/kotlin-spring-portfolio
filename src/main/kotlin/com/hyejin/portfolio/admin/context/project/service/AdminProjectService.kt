package com.hyejin.portfolio.admin.context.project.service

import com.hyejin.portfolio.admin.data.TableDTO
import com.hyejin.portfolio.admin.exception.AdminBadRequestException
import com.hyejin.portfolio.domain.entity.Project
import com.hyejin.portfolio.domain.entity.ProjectDetail
import com.hyejin.portfolio.domain.repository.ProjectRepository
import org.springframework.stereotype.Service

@Service
class AdminProjectService(
    private val projectRepository: ProjectRepository
) {
    fun getProjectTable(): TableDTO {
        return TableDTO.from(Project::class, projectRepository.findAll(), "details", "skills")
    }

    fun getProjectTable(id: Long?): TableDTO {
        val entities = if (id != null)
            projectRepository.findById(id)
                .orElseThrow { throw AdminBadRequestException("ID ${id}에 해당하는 데이터를 찾을 수 없습니다.") }
                .details
        else emptyList()

        return TableDTO.from(ProjectDetail::class, entities)
    }
}