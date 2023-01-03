import java.io.File

fun main() {
    val results = mapOf(
        "rock" to "scissors",
        "scissors" to "paper",
        "paper" to "rock"
    )
    val player2results = mapOf(
        "paper" to "scissors",
        "scissors" to "rock",
        "rock" to "paper"
    )
    val points = mapOf(
        "rock" to 1,
        "paper" to 2,
        "scissors" to 3,
        "lose" to 0,
        "win" to 6,
        "draw" to 3
    )

    val moves = mapOf(
        "A" to "rock",
        "B" to "paper",
        "C" to "scissors",
        "X" to "rock",
        "Y" to "paper",
        "Z" to "scissors"
    )

    var player1points = 0
    var player2points = 0

    fun playing(player1: String?, player2: String?): String {
        if (player2 == "Y") {
            player1points += points["draw"]!!
            player2points += points["draw"]!!
            player1points += points[player1]!! ?: 0
            player2points += points[player1]!! ?: 0
            return "draw"

        }
        if (player2 == "X") {
            player1points += points["win"]!!
            player2points += points["lose"]!!
            player1points += points[player1]!! ?: 0
            player2points += points[results[player1]]!! ?: 0
            return "win"
        }
        if (player2 == "Z") {
            player1points += points["lose"]!!
            player2points += points["win"]!!
            player1points += points[player1]!! ?: 0
            player2points += points[player2results[player1]]!! ?: 0
            return "lose"
        }
        return "lose"
    }

    val data = File("src/Day02.txt").readLines()
    var player1 = mutableListOf<String>()
    var player2 = mutableListOf<String>()
    var play = mutableListOf("","")

    fun getPlays(data: List<String>) {
        for (line in data) {
            play.clear()
            line.split(" ").forEach {
                play.add(it)
            }
            println(moves[play[0]])
            println(moves[play[1]])
            println("---------------------")
            println(playing(moves[play[0]], play[1]))
            println("---------------------")
        }
    }
    getPlays(data)
    println("Player 1: $player1points")
    println("Player 2: $player2points")

}
