package omegacasemanagement.filterservice.controller

import omegacasemanagement.filterservice.dto.CaseFilterDTO
import omegacasemanagement.filterservice.models.Case
import omegacasemanagement.filterservice.service.ICaseFilterService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/case-filter")
class CaseFilterController(private val caseFilterService: ICaseFilterService) {
    @PostMapping
    fun filterCases(@RequestBody payload: CaseFilterDTO): List<Case> {
        return this.caseFilterService.filterCases(payload)
    }
}
