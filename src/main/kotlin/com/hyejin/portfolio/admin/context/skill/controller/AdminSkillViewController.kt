package com.hyejin.portfolio.admin.context.skill.controller

import com.hyejin.portfolio.admin.context.skill.service.AdminSkillService
import com.hyejin.portfolio.admin.data.FormElementDTO
import com.hyejin.portfolio.admin.data.SelectFormElementDTO
import com.hyejin.portfolio.admin.data.TextFormElementDTO
import com.hyejin.portfolio.domain.contant.SkillType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/skill")
class AdminSkillViewController(
    private val adminSkillService: AdminSkillService
) {
    @GetMapping
    fun skill(model: Model): String {
        val elements = listOf<FormElementDTO>(
            TextFormElementDTO("name", 2),
            SelectFormElementDTO("type", 2, SkillType.entries.map { it.name }.toMutableList()),
            SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString())),
        )
        model.addAttribute("formElements", elements)

        val table = adminSkillService.getSkillTable()
        model.addAttribute("table", table)
        model.addAttribute("detailTable", null)

        val pageAttributes = mutableMapOf<String, Any>(
            Pair("menuName", "Resume"),
            Pair("pageName", table.name),
            Pair("editable", true),
            Pair("deletable", false),
            Pair("hasDetails", false)
        )
        model.addAllAttributes(pageAttributes)

        return "admin/page-table"
    }
}