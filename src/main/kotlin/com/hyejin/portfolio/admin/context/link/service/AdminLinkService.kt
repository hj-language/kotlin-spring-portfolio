package com.hyejin.portfolio.admin.context.link.service

import com.hyejin.portfolio.admin.context.link.form.LinkForm
import com.hyejin.portfolio.admin.data.TableDTO
import com.hyejin.portfolio.domain.entity.Link
import com.hyejin.portfolio.domain.repository.LinkRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminLinkService(
    private val linkRepository: LinkRepository
) {
    fun getLinkTable(): TableDTO {
        return TableDTO.from(Link::class, linkRepository.findAll())
    }

    @Transactional
    fun save(form: LinkForm) {
        linkRepository.save(form.toEntity())
    }

    @Transactional
    fun update(id: Long, form: LinkForm) {
        linkRepository.save(form.toEntity(id))
    }
}