import java.lang.IllegalStateException

/**
 * Задача: на вход подается число n. Вывести на экран таблицу умножения
 * всех чисел от 1 до m. Обосновать свой выборо парадигмы.
 * */
fun main(args: Array<String>) {
    val userNumber = getNumberFromConsole()
    printMultiplicationTable(userNumber)
}
    fun getNumberFromConsole(): Int {
        var userInput: String = ""
        while (userInput == "") {
            println("Введите число: ")
            userInput = readLine().toString()
        }
        var userNum = 0
        try {
            userNum = userInput.toInt()
        } catch (e: NumberFormatException) {
            println("Вы ввели не число")
        }
        return userNum
    }

    fun printMultiplicationTable(number: Int, countColumn: Int = 5) {
        val countBlocks = (number + countColumn) / countColumn
        for (k in 0..countBlocks) {
            var stopper: Int = if (k == countBlocks) number else k * countBlocks + countColumn
            for (i in 1..9) {
                for (j in (k * countColumn + 1)..stopper) {
                    print("${j} * ${i} = ${i * j}     ")
                }
                println()
            }
            println()
        }
    }




