package com.hyejin.portfolio.admin.context.link.service

import com.hyejin.portfolio.admin.data.TableDTO
import com.hyejin.portfolio.domain.entity.Link
import com.hyejin.portfolio.domain.repository.LinkRepository
import org.springframework.stereotype.Service

@Service
class AdminLinkService(
    private val linkRepository: LinkRepository
) {
    fun getLinkTable(): TableDTO {
        return TableDTO.from(Link::class, linkRepository.findAll())
    }
}