package com.hyejin.portfolio.domain.repository

import com.hyejin.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Long> {
    // 1:N 관계여서 성능이 좋지 않음 - 추후 개선
    fun findAllByIsActive(isActive: Boolean): List<Project>
}