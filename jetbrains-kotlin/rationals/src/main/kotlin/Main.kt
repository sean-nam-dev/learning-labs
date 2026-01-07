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

    infix operator fun times(other: Rational): Rational {
        val numerator = numerator * other.numerator
        val denominator = denominator * other.denominator

        return normalize(
            Rational(
                numerator = numerator,
                denominator = denominator
            )
        )
    }

    infix operator fun div(other: Rational): Rational {
        return normalize(
            Rational(
                numerator = this.numerator * other.denominator,
                denominator = this.denominator * other.numerator
            )
        )
    }

    operator fun unaryMinus(): Rational {
        return normalize(
            Rational(
                numerator = -this.numerator,
                denominator = this.denominator
            )
        )
    }

    operator fun rangeTo(other: Rational): ClosedRange<Rational> {
        return object : ClosedRange<Rational> {
            override val start: Rational
                get() = this@Rational
            override val endInclusive: Rational
                get() = other
        }
    }
}

fun String.toRational(): Rational {
    val nums = this.split('/').map { it.toBigInteger() }

    return normalize(
        if (nums.size > 1) {
            Rational(
                numerator = nums.first(),
                denominator = nums.last()
            )
        } else {
            Rational(
                numerator = nums.first(),
                denominator = BigInteger.ONE
            )
        }
    )
}

private fun normalize(rational: Rational): Rational {
    val gcd = rational.numerator.gcd(rational.denominator)

    var (numerator, denominator) = rational.numerator / gcd to rational.denominator / gcd

    if (denominator < BigInteger.ZERO) {
        numerator *= (-1).toBigInteger()
        denominator *= (-1).toBigInteger()
    }

    return Rational(
        numerator = numerator,
        denominator = denominator
    )
}