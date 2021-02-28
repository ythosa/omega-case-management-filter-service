package omegacasemanagement.filterservice.models

data class Case(
    val id: Int,
    val name: String,
    val startDate: String,
    val endDate: String,
    val budget: Int,
    val problems: String,
    val type: CaseType,
    val command: Command,
    val industry: Industry,
    val presentation: Presentation,
    val customer: Customer,
    val technologies: Array<Technology>,
    val workDirections: Array<WorkDirection>,
    val nominations: Array<Nomination>,
    val mediaFiles: Array<MediaFile>,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Case

        if (id != other.id) return false
        if (name != other.name) return false
        if (startDate != other.startDate) return false
        if (endDate != other.endDate) return false
        if (budget != other.budget) return false
        if (problems != other.problems) return false
        if (type != other.type) return false
        if (command != other.command) return false
        if (industry != other.industry) return false
        if (presentation != other.presentation) return false
        if (customer != other.customer) return false
        if (!technologies.contentEquals(other.technologies)) return false
        if (!workDirections.contentEquals(other.workDirections)) return false
        if (!nominations.contentEquals(other.nominations)) return false
        if (!mediaFiles.contentEquals(other.mediaFiles)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + startDate.hashCode()
        result = 31 * result + endDate.hashCode()
        result = 31 * result + budget.hashCode()
        result = 31 * result + problems.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + command.hashCode()
        result = 31 * result + industry.hashCode()
        result = 31 * result + presentation.hashCode()
        result = 31 * result + customer.hashCode()
        result = 31 * result + technologies.contentHashCode()
        result = 31 * result + workDirections.contentHashCode()
        result = 31 * result + nominations.contentHashCode()
        result = 31 * result + mediaFiles.contentHashCode()
        return result
    }
}
