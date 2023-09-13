import kotlin.math.roundToInt

fun main(args: Array<String>) {
    val studentDate = listOf(
        (mapOf("name" to "Alice", "score" to "85")),
        mapOf("name" to "Bob", "score" to "92"),
        mapOf("name" to "Charlie", "score" to "78"),
        mapOf("name" to "David", "score" to "95")
    )
    var summa: Double = 0.0
    for (student in studentDate) {
        summa += (student.get("score")?.toInt() ?: 0)
    }
    val average: Int = (summa / studentDate.size).roundToInt()
    val aboveAverageStudents: MutableList<Map<String, String>> = mutableListOf()
    for (studious in studentDate) {
        if ((studious.get("score")?.toInt() ?: 0) >= average) {
            aboveAverageStudents.add(studious)
        }
    }
    println("Средний балл: $average")
    println("Студенты с баллом выше среднег: $aboveAverageStudents")
}



