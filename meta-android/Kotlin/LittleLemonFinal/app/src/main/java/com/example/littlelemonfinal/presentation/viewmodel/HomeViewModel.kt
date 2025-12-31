package com.example.littlelemonfinal.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.littlelemonfinal.domain.model.Menu
import com.example.littlelemonfinal.domain.usecase.NetworkFetchUsecase
import com.example.littlelemonfinal.presentation.action.HomeAction
import com.example.littlelemonfinal.util.FilterType
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class HomeViewModel(
    private val networkFetchUsecase: NetworkFetchUsecase
) : ViewModel(), HomeAction {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000L),
        initialValue = ""
    )

    private val _filter = MutableStateFlow<List<FilterType>>(emptyList())
    val filter = _filter.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000L),
        initialValue = emptyList()
    )

    private val menuSource = flow {
        emit(networkFetchUsecase())
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList()
    )

    val menuList = combine(
        menuSource,
        searchQuery,
        filter
    ) { menu, search, filter ->
        menu.filter { item ->
            val searchResult =
                search.isBlank() ||
                        item.title.contains(search, ignoreCase = true) ||
                        item.description.contains(search, ignoreCase = true)

            val filterResult =
                filter.isEmpty() ||
                        filter.any { it.value.equals(item.category, ignoreCase = true) }

            searchResult && filterResult
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000L),
        initialValue = emptyList()
    )

    override fun onSearchQuery(query: String) {
        _searchQuery.update { query }
    }

    override fun onFilter(type: FilterType) {
        if (_filter.value.contains(type)) {
            _filter.update { it - type }
        } else {
            _filter.update { it + type }
        }
    }
}