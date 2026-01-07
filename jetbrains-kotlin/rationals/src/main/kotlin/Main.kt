package org.example

import java.math.BigInteger

fun main() {

}

data class Rational(
    val numerator: BigInteger,
    val denominator: BigInteger
) : Comparable<Rational> {

    init {
        if (denominator == BigInteger.ZERO) {
            throw IllegalArgumentException()
        }
    }

    override fun toString(): String {
        return if (denominator == 1.toBigInteger()) {
            "$numerator"
        } else {
            "$numerator/$denominator"
        }
    }

    override fun compareTo(other: Rational): Int {
        val diff = this - other
        return when {
            diff.numerator < BigInteger.ZERO -> -1
            diff.numerator > BigInteger.ZERO -> 1
            else -> 0
        }
    }

    infix operator fun plus(other: Rational): Rational {
        val g = denominator.gcd(other.denominator)

        val a = numerator * (other.denominator / g)
        val b = other.numerator * (denominator / g)

        val num = a + b
        val den = (denominator / g) * other.denominator

        val finalGcd = num.gcd(den)
        return Rational(num / finalGcd, den / finalGcd)
    }

    infix operator fun minus(other: Rational): Rational {
        val gcdDen = denominator.gcd(other.denominator)
        val num = numerator * (other.denominator / gcdDen) - other.numerator * (denominator / gcdDen)
        val den = (denominator * other.denominator) / gcdDen
        val finalGcd = num.gcd(den)

        return Rational(
            numerator = num / finalGcd,
            denominator = den / finalGcd
        )
    }
}