package org.example

fun main() {
    println("abaca".isNice() == false)
    println("baaa".isNice() == true)
    println("wddf".isNice() == true)
}

fun String.isNice(): Boolean {
    return this.run {
        listOf(
            checkSubstring(),
            containsVowels(),
            containsDoubleLetter()
        ).count { it } >= 2
    }
}

fun String.checkSubstring(): Boolean {
    val subList = listOf("bu", "ba", "be")

    subList.forEach {
        if (it in this) {
            return false
        }
    }

    return true
}

fun String.containsVowels(): Boolean {
    var counter = 0
    val vowelList = listOf('a', 'e', 'i', 'o', 'u')

    this.forEach {
        if (it in vowelList) counter++
    }

    return counter >= 3
}

fun String.containsDoubleLetter(): Boolean {
    var index = 0
    var lastChar: Char? = null

    while (index < this.length) {
        if (this[index] == lastChar) {
            return true
        } else {
            lastChar = this[index]
        }

        index++
    }

    return false
}