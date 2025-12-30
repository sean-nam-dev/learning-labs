package com.example.littlelemonfinal.di

import android.content.Context
import android.content.SharedPreferences
import com.example.littlelemonfinal.data.SharedPrefsRepositoryImpl
import com.example.littlelemonfinal.domain.ReadPersonalInfoUsecase
import com.example.littlelemonfinal.domain.ReadStartDestinationUsecase
import com.example.littlelemonfinal.domain.SharedPrefsRepository
import com.example.littlelemonfinal.domain.WritePersonalInfoUsecase
import com.example.littlelemonfinal.domain.WriteStartDestinationUsecase
import com.example.littlelemonfinal.presentation.viewmodel.LogoutViewModel
import com.example.littlelemonfinal.presentation.viewmodel.MainViewModel
import com.example.littlelemonfinal.presentation.viewmodel.RegisterViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<SharedPreferences> {
        androidContext().getSharedPreferences(
            "shared_prefs",
            Context.MODE_PRIVATE
        )
    }

    single<SharedPrefsRepository> {
        SharedPrefsRepositoryImpl(
            sharedPrefs = get()
        )
    }

    factory<ReadStartDestinationUsecase> {
        ReadStartDestinationUsecase(
            sharedPrefsRepository = get()
        )
    }

    factory<WriteStartDestinationUsecase> {
        WriteStartDestinationUsecase(
            sharedPrefsRepository = get()
        )
    }

    factory<ReadPersonalInfoUsecase> {
        ReadPersonalInfoUsecase(
            sharedPrefsRepository = get()
        )
    }

    factory<WritePersonalInfoUsecase> {
        WritePersonalInfoUsecase(
            sharedPrefsRepository = get()
        )
    }

    viewModel<MainViewModel> {
        MainViewModel(
            readStartDestinationUsecase = get()
        )
    }

    viewModel<RegisterViewModel> {
        RegisterViewModel(
            writeStartDestinationUsecase = get(),
            writePersonalInfoUsecase = get(),
        )
    }

    viewModel<LogoutViewModel> {
        LogoutViewModel(
            readPersonalInfoUsecase = get(),
            writePersonalInfoUsecase = get(),
            writeStartDestinationUsecase = get()
        )
    }
}