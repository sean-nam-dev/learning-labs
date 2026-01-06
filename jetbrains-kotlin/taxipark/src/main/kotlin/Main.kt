package org.example

import kotlin.math.floor

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

}

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> {
    val activeDrivers = this.trips.map { it.driver }.toSet()

    return this.allDrivers - activeDrivers
}