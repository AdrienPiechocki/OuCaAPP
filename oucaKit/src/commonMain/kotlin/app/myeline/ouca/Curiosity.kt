package app.myeline.ouca


data class Curiosity (
    val category: Category,
    val name: String,
    val latitude: Float,
    val longitude: Float
) {
    enum class Category {
        HISTORIC, ARCHITECTURAL, ARTISTIC
    }
}

//sealed interface Curiosity {
//    val name: String
//    val latitude: Float
//    val longitude: Float
//}
//data class HistoricCuriosity(
//    override val name: String,
//    override val latitude: Float,
//    override val longitude: Float
//): Curiosity
//
//data class ArchitecturalCuriosity(
//    override val name: String,
//    override val latitude: Float,
//    override val longitude: Float
//): Curiosity
//
//data class ArtisticCuriosity(
//    override val name: String,
//    override val latitude: Float,
//    override val longitude: Float
//): Curiosity
