package omegacasemanagement.filterservice.models

data class CaseFilters(
    val minBudget: Int?,
    val maxBudget: Int?,
    val technologies: List<String>?,
    val workDirections: List<String>?,
    val customers: List<String>?,
    val industries: List<String>?,
    val nominations: List<String>?,
    val caseTypes: List<String>?,
)
