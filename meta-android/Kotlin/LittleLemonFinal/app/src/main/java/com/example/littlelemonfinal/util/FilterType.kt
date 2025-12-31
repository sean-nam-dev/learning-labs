package com.example.littlelemonfinal.util

sealed class FilterType(val value: String) {

    data object None : FilterType("None")

    data object Starters : FilterType("Starters")

    data object Mains : FilterType("Mains")

    data object Desserts : FilterType("Desserts")

    data object Soups : FilterType("Soups")

    data object Drinks : FilterType("Drinks")
}