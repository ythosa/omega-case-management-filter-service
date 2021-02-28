package omegacasemanagement.filterservice.dto

import omegacasemanagement.filterservice.models.Case
import omegacasemanagement.filterservice.models.CaseFilters

data class CaseFilterDTO(
    val caseFilters: CaseFilters,
    val cases: List<Case>
)
