package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val result = Evaluation(1, 1)
    println(evaluateGuess("BCDF", "ACEB") == result)
    println(evaluateGuess("AAAF", "ABCA") == result)
    println(evaluateGuess("ABCA", "AAAF") == result)
}

data class Evaluation(
    val rightPosition: Int,
    val wrongPosition: Int
)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    val rightPositions = secret.zip(guess).count { it.first == it.second }
    val commonLetters = "ABCDEF".sumOf { ch ->
        secret.count { it == ch }.coerceAtMost(guess.count { it == ch })
    }

    return Evaluation(rightPositions, commonLetters - rightPositions)
}