package com.example.littlelemonfinal.presentation.action

import com.example.littlelemonfinal.util.FilterType

interface HomeAction {

    fun onSearchQuery(query: String)

    fun onFilter(type: FilterType)
}