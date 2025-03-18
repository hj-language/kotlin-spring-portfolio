package com.hyejin.portfolio.admin.context.achievement.controller

import com.hyejin.portfolio.admin.context.achievement.service.AdminExperienceService
import com.hyejin.portfolio.admin.data.FormElementDTO
import com.hyejin.portfolio.admin.data.SelectFormElementDTO
import com.hyejin.portfolio.admin.data.TextFormElementDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/experience")
class AdminExperienceViewController(
    private val adminExperienceService: AdminExperienceService
) {
    @GetMapping
    fun experience(model: Model): String {
        val elements = listOf<FormElementDTO>(
            TextFormElementDTO("title", 4),
            SelectFormElementDTO("startYear", 3, (2010..2030).toList()),
            SelectFormElementDTO("startMonth", 2, (1..12).toList()),
            SelectFormElementDTO("endYear", 3, (2010..2030).toList()),
            SelectFormElementDTO("endMonth", 2, (1..12).toList()),
            SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString())),
        )
        model.addAttribute("formElements", elements)

        val detailElements = listOf<FormElementDTO>(
            TextFormElementDTO("content", 10),
            SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString())),
        )
        model.addAttribute("detailFormElements", elements)

        val table = adminExperienceService.getExperienceTable()
        model.addAttribute("table", table)

        val detailTable = adminExperienceService.getExperienceTable(null)
        model.addAttribute("detailTable", detailTable)

        val pageAttributes = mutableMapOf<String, Any>(
            Pair("menuName", "Resume"),
            Pair("pageName", table.name),
            Pair("editable", true),
            Pair("deletable", false),
            Pair("hasDetails", true)
        )
        model.addAllAttributes(pageAttributes)

        return "admin/page-table"
    }
}