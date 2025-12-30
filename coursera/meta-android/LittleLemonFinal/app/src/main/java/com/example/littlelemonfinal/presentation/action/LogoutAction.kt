package com.example.littlelemonfinal.presentation.action

interface LogoutAction {

    fun logout()

    fun getData(): Triple<String, String, String>
}