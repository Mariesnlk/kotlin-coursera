package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    val rightPosition = getGuessedInRightPosition(secret, guess)
    val wrongPosition = getGuessedInWrongPosition(secret, guess)

    return Evaluation(rightPosition, wrongPosition)
}


private fun getGuessedInRightPosition(secret: String, guess: String): Int {
    var spots = 0
    for (i in 0 until secret.length) {
        if (secret[i] == guess[i]) spots++
    }
    return spots
}

private fun getGuessedInWrongPosition(secret: String, guess: String): Int {
    var count = 0
    var newSecret = ""
    var newGuess = ""
    for (i in 0 until secret.length) {
        if (secret[i] != guess[i]) {
            newSecret += secret[i]
            newGuess += guess[i]
        }
    }
    val evaluatedListOfChars = mutableListOf<Char>()
    if (!newSecret.isEmpty()) {
        for (i in 0 until guess.length) {
            val letter = guess[i]
            if (!evaluatedListOfChars.contains(letter)) {
                val howManyInSecret = countLetters(newSecret, letter)
                val howManyInGuess = countLetters(newGuess, letter)
                count += if (howManyInSecret == howManyInGuess || howManyInSecret > howManyInGuess) howManyInGuess
                else howManyInSecret
                evaluatedListOfChars.add(letter)
            }
        }
    }
    return count
}

private fun countLetters(letters: String, letter: Char): Int {
    var count = 0
    for (i in 0 until letters.length) {
        if (letters[i] == letter) count++
    }
    return count
}

