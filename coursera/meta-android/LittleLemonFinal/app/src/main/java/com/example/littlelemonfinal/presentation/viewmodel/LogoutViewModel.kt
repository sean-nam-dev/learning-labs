package com.example.littlelemonfinal.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.littlelemonfinal.domain.ReadPersonalInfoUsecase
import com.example.littlelemonfinal.domain.WritePersonalInfoUsecase
import com.example.littlelemonfinal.domain.WriteStartDestinationUsecase
import com.example.littlelemonfinal.navigation.Destination
import com.example.littlelemonfinal.presentation.action.LogoutAction

class LogoutViewModel(
    private val readPersonalInfoUsecase: ReadPersonalInfoUsecase,
    private val writePersonalInfoUsecase: WritePersonalInfoUsecase,
    private val writeStartDestinationUsecase: WriteStartDestinationUsecase
) : ViewModel(), LogoutAction {

    override fun logout() {
        writePersonalInfoUsecase(Triple("", "", ""))
        writeStartDestinationUsecase(Destination.Register.toString())
    }

    override fun getData(): Triple<String, String, String> = readPersonalInfoUsecase()
}