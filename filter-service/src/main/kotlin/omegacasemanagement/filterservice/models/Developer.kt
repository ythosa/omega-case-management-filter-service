package omegacasemanagement.filterservice.models

data class Developer(
    val id: Int,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val experience: Int,
    val technologies: List<Technology>,
    val workDirections: List<WorkDirection>
)
