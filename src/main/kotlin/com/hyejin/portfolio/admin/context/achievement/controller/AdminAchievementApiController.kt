package com.hyejin.portfolio.admin.context.achievement.controller

import com.hyejin.portfolio.admin.context.achievement.form.AchievementForm
import com.hyejin.portfolio.admin.context.achievement.service.AdminAchievementService
import com.hyejin.portfolio.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin/api/achievements")
class AdminAchievementApiController(
    private val adminAchievementService: AdminAchievementService
) {
    @PostMapping
    fun postAchievement(@RequestBody @Validated form: AchievementForm): ResponseEntity<Any> {
        adminAchievementService.save(form)
        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun puhAchievement(@PathVariable id: Long, @RequestBody form: AchievementForm): ResponseEntity<Any> {
        adminAchievementService.update(id, form)
        return ApiResponse.successUpdate()
    }
}