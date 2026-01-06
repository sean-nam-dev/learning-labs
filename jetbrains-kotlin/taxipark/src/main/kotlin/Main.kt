package org.example

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.times

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println(Temp.data.checkParetoPrinciple() == false)
}

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> {
    val activeDrivers = this.trips.map { it.driver }.toSet()

    return this.allDrivers - activeDrivers
}

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> {
    if (minTrips == 0) return allPassengers

    val passengerMap = mutableMapOf<Passenger, Int>()

    this.trips.forEach { trip ->
        trip.passengers.forEach { passenger ->
            passengerMap[passenger] = passengerMap.getOrDefault(passenger, 0) + 1
        }
    }

    return passengerMap.filter { it.value >= minTrips }.keys
}

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> {
    val result = mutableMapOf<Passenger, Int>()

    this.trips.forEach { trip ->
        if (trip.driver == driver) {
            trip.passengers.forEach { passenger ->
                result[passenger] = result.getOrDefault(passenger, 0) + 1
            }
        }
    }

    return result.filter { it.value > 1 }.keys
}

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> {
    val temp = mutableMapOf<Passenger, List<Double?>>()

    this.trips.forEach { trip ->
        trip.passengers.forEach { passenger ->
            temp[passenger] = temp.getOrDefault(passenger, emptyList()) + trip.discount
        }
    }

    val result = mutableSetOf<Passenger>()

    temp.forEach { entry ->
        val nullCount = entry.value.count { it == null }
        val doubleCount = entry.value.count { it != null }

        if (doubleCount > nullCount) {
            result += entry.key
        }
    }

    return result
}

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {
    val durationList = mutableListOf<Int>()

    this.trips.forEach { trip ->
        durationList += trip.duration
    }

    return if (durationList.isEmpty()) {
        null
    } else {
        val max = durationList.maxOf { it }

        val periodList = mutableListOf<IntRange>()
        var index = 0
        while (index < max) {
            periodList += index..(index + 9)
            index += 10
        }

        val result = mutableMapOf<IntRange, Int>()

        durationList.forEach { duration ->
            var innerIndex = 0

            while (innerIndex < periodList.size) {
                if (duration in periodList[innerIndex]) {
                    result[periodList[innerIndex]] = result.getOrDefault(periodList[innerIndex], 0) + 1
                    break
                }

                innerIndex++
            }
        }


        result.maxBy { it.value }.key
    }
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {
    if (allDrivers.isEmpty() || trips.isEmpty()) return false

    val topDriversCount = floor(allDrivers.size * 0.2).coerceAtLeast(1.0).toInt()
    val tripDriverMap = mutableMapOf<Driver, Double>()

    trips.forEach { trip ->
        tripDriverMap[trip.driver] = tripDriverMap.getOrDefault(trip.driver, 0.0) + trip.cost
    }

    allDrivers.forEach { driver ->
        if (!tripDriverMap.contains(driver)) {
            tripDriverMap[driver] = 0.0
        }
    }

    val total = tripDriverMap
        .values
        .sortedDescending()
        .take(topDriversCount)
        .sum()

    val targetIncome = tripDriverMap.values.sum() * 0.8

    return total >= targetIncome
}