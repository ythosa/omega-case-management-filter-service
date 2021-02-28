package omegacasemanagement.filterservice.service

import omegacasemanagement.filterservice.dto.CaseFilterDTO
import omegacasemanagement.filterservice.models.Case
import org.springframework.stereotype.Service

@Service
class CaseFilterService : ICaseFilterService {
    override fun filterCases(payload: CaseFilterDTO): List<Case> {
        var cases: List<Case> = payload.cases

        cases = this.filterByBudget(payload.caseFilters.minBudget, payload.caseFilters.maxBudget, cases)
        cases = this.filterByTechnologies(payload.caseFilters.technologies, cases)
        cases = this.filterByWorkDirections(payload.caseFilters.workDirections, cases)
        cases = this.filterByCustomer(payload.caseFilters.customers, cases)
        cases = this.filterByIndustry(payload.caseFilters.industries, cases)
        cases = this.filterByNominations(payload.caseFilters.nominations, cases)
        cases = this.filterByCaseType(payload.caseFilters.caseTypes, cases)

        return cases
    }

    private fun filterByBudget(min: Int?, max: Int?, cases: List<Case>): List<Case> {
        var filtered: List<Case> = cases

        if (max != null) {
            filtered = cases.filter { it.budget < max }
        }

        if (min != null) {
            filtered = filtered.filter { it.budget > min }
        }

        return filtered
    }

    private fun filterByTechnologies(technologies: List<String>?, cases: List<Case>): List<Case> {
        if (technologies == null) return cases

        val filtered: MutableList<Case> = mutableListOf()

        for (c in cases) {
            val caseTechnologies = c.technologies.map { it.name }
            for (t in caseTechnologies) {
                if (technologies.contains(t)) {
                    filtered.add(c)

                    break
                }
            }
        }

        return filtered
    }

    private fun filterByWorkDirections(workDirections: List<String>?, cases: List<Case>): List<Case> {
        if (workDirections == null) return cases

        val filtered: MutableList<Case> = mutableListOf()

        for (c in cases) {
            val caseWorkDirections = c.workDirections.map { it.name }
            for (wd in caseWorkDirections) {
                if (workDirections.contains(wd)) {
                    filtered.add(c)

                    break
                }
            }
        }

        return filtered
    }

    private fun filterByCustomer(customers: List<String>?, cases: List<Case>): List<Case> {
        if (customers == null) return cases

        val filtered: MutableList<Case> = mutableListOf()

        for (c in cases) {
            if (customers.contains(c.customer.name)) {
                filtered.add(c)
            }
        }

        return filtered
    }

    private fun filterByIndustry(industries: List<String>?, cases: List<Case>): List<Case> {
        if (industries == null) return cases

        val filtered: MutableList<Case> = mutableListOf()

        for (c in cases) {
            if (industries.contains(c.industry.name)) {
                filtered.add(c)
            }
        }

        return filtered
    }

    private fun filterByNominations(nominations: List<String>?, cases: List<Case>): List<Case> {
        if (nominations == null) return cases

        val filtered: MutableList<Case> = mutableListOf()

        for (c in cases) {
            val caseNominations = c.nominations.map { it.name }
            for (cn in caseNominations) {
                if (nominations.contains(cn)) {
                    filtered.add(c)

                    break
                }
            }
        }

        return filtered
    }

    private fun filterByCaseType(caseTypes: List<String>?, cases: List<Case>): List<Case> {
        if (caseTypes == null) return cases

        val filtered: MutableList<Case> = mutableListOf()

        for (c in cases) {
            if (caseTypes.contains(c.type.type)) {
                filtered.add(c)
            }
        }

        return filtered
    }
}
