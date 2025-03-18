package com.hyejin.portfolio.admin.context.introduction.service

import com.hyejin.portfolio.admin.data.TableDTO
import com.hyejin.portfolio.domain.entity.Introduction
import com.hyejin.portfolio.domain.repository.IntroductionRepository
import org.springframework.stereotype.Service

@Service
class AdminIntroductionService(
    private val introductionRepository: IntroductionRepository
) {
    fun getIntroductionTable(): TableDTO {
        return TableDTO.from(Introduction::class, introductionRepository.findAll())
    }
}