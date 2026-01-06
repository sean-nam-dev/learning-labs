package org.example

object Temp {
    val data = TaxiPark(
        allDrivers = setOf(
            Driver("Driver 0"),
            Driver("Driver 1"),
            Driver("Driver 2"),
            Driver("Driver 3"),
            Driver("Driver 4"),
            Driver("Driver 5")
        ),
        allPassengers = setOf(
            Passenger("Passenger 0"),
            Passenger("Passenger 1"),
            Passenger("Passenger 2"),
            Passenger("Passenger 3"),
            Passenger("Passenger 4"),
            Passenger("Passenger 5"),
            Passenger("Passenger 6"),
            Passenger("Passenger 7"),
            Passenger("Passenger 8"),
            Passenger("Passenger 9")
        ),
        trips = listOf(
            Trip(
                driver = Driver("Driver 1"),
                passengers = setOf(
                    Passenger("Passenger 6"),
                    Passenger("Passenger 1")
                ),
                duration = 22,
                distance = 12.0,
                discount = null
            ),
            Trip(
                driver = Driver("Driver 0"),
                passengers = setOf(
                    Passenger("Passenger 5"),
                    Passenger("Passenger 6")
                ),
                duration = 17,
                distance = 18.0,
                discount = null
            ),
            Trip(
                driver = Driver("Driver 1"),
                passengers = setOf(
                    Passenger("Passenger 9"),
                    Passenger("Passenger 7"),
                    Passenger("Passenger 3"),
                    Passenger("Passenger 1"),
                ),
                duration = 30,
                distance = 14.0,
                discount = 0.1
            ),
            Trip(
                driver = Driver("Driver 0"),
                passengers = setOf(
                    Passenger("Passenger 2"),
                ),
                duration = 0,
                distance = 2.0,
                discount = 0.1
            ),
            Trip(
                driver = Driver("Driver 0"),
                passengers = setOf(
                    Passenger("Passenger 4"),
                ),
                duration = 0,
                distance = 1.0,
                discount = 0.4
            ),
            Trip(
                driver = Driver("Driver 0"),
                passengers = setOf(
                    Passenger("Passenger 7"),
                    Passenger("Passenger 2"),
                    Passenger("Passenger 4"),
                ),
                duration = 25,
                distance = 24.0,
                discount = 0.1
            ),
            Trip(
                driver = Driver("Driver 0"),
                passengers = setOf(
                    Passenger("Passenger 2"),
                ),
                duration = 28,
                distance = 2.0,
                discount = null
            ),
            Trip(
                driver = Driver("Driver 0"),
                passengers = setOf(
                    Passenger("Passenger 9"),
                    Passenger("Passenger 1"),
                    Passenger("Passenger 3"),
                ),
                duration = 6,
                distance = 15.0,
                discount = null
            ),
            Trip(
                driver = Driver("Driver 0"),
                passengers = setOf(
                    Passenger("Passenger 0"),
                ),
                duration = 27,
                distance = 22.0,
                discount = null
            ),
            Trip(
                driver = Driver("Driver 0"),
                passengers = setOf(
                    Passenger("Passenger 4"),
                    Passenger("Passenger 5"),
                    Passenger("Passenger 7"),
                    Passenger("Passenger 3"),
                ),
                duration = 4,
                distance = 26.0,
                discount = 0.1
            )
        )
    )
}