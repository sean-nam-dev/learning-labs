package com.example.littlelemonfinal.domain

class WriteStartDestinationUsecase(
    private val sharedPrefsRepository: SharedPrefsRepository
) {
    operator fun invoke(data: String) {
        sharedPrefsRepository.write(
            Util.START_DESTINATION,
            data
        )
    }
}