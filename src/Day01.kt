import java.io.File

fun main() {
    var currentGroup = mutableListOf<Int>()
    var groups = mutableListOf<List<Int>>()
    var totals = mutableListOf<Int>()
    fun part1(inputs: List<String>) {
        for (input in inputs) {
            println(input)
            if (input.isEmpty()) {
                // If the line is empty, add the current group to the list of groups
                // and start a new group
                groups.add(currentGroup)
                currentGroup = mutableListOf<Int>()
            } else {
                // If the line is not empty, convert the string to an integer and
                // add it to the current group
                currentGroup.add(input.trim().toInt())
            }
        }
        for (group in groups) {
            totals.add(group.sum())
        }
        totals.sortDescending()
        var total = 0
        for (i in 0..2) {
            total += totals[i]
        }
        println("Total: $total")
    }

    groups.add(currentGroup)

    // test if implementation meets criteria from the description, like:
    val testInput = File("src/Day01.txt").readLines()
    part1(testInput)
    //
    /*val input = readInput("Day01")
    part1(input).println()
    part2(input).println()*/
}
