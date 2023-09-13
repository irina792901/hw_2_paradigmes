import kotlin.math.roundToInt

fun main(args: Array<String>) {
    val studentDate = listOf(
        (mapOf("name" to "Alice", "score" to "85")),
        mapOf("name" to "Bob", "score" to "92"),
        mapOf("name" to "Charlie", "score" to "78"),
        mapOf("name" to "David", "score" to "95")
    )
    val average = getAverage(studentDate)
    val aboveAverageStudents = getAboveAverageStudents(studentDate, average)
    println("Средний балл: $average")
    println("Студенты с баллом выше среднег: $aboveAverageStudents")
}

fun getAverage(students: List<Map<String, String>>): Int {
    var summa: Double = 0.0
    for (student in students)
        summa += (student.get("score"))?.toInt() ?: 0
    return (summa / students.size).roundToInt()
}

fun getAboveAverageStudents(studiouses: List<Map<String, String>>, middle: Int): MutableList<Map<String, String>> {
    val result: MutableList<Map<String, String>> = mutableListOf()
    for (studious in studiouses) {
        if ((studious.get("score")?.toInt() ?:0) >=middle) {
                result.add(studious)
            }
    }
    return result
}








