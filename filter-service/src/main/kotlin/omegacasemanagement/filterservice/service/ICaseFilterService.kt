package omegacasemanagement.filterservice.service

import omegacasemanagement.filterservice.dto.CaseFilterDTO
import omegacasemanagement.filterservice.models.Case

interface ICaseFilterService {
    fun filterCases(payload: CaseFilterDTO): List<Case>
}
