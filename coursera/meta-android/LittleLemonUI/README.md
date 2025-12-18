# LittleLemonUI

An educational Android project created as part of the **Meta Android Developer Professional Certificate (Coursera)**.

## Project Overview
This project is focused **exclusively on UI development** with **Jetpack Compose**.  
The main goal is to practice building composable screens, managing UI state, and structuring a Compose-based application.

Networking, persistence, and production concerns are intentionally out of scope.

## Screenshot

<img src="https://github.com/user-attachments/assets/88c8af43-9755-4278-8b75-f6ceccaa47cf" width="360"/>

## Learning Objectives
- Building UI with Jetpack Compose
- Screen composition and layout
- Type-safe navigation between screens
- Sharing state via ViewModel
- Basic UI-driven sorting logic
- Applying Material Design 3 components
- Structuring UI code in a clean and readable way

## Features
- Menu list screen
- Item details screen
- Navigation using a sealed `Destination` model
- Shared ViewModel scoped to a navigation graph
- UI state handling with `StateFlow`
- Sorting menu items from the Top App Bar
- Material 3 theming and components

## Tech Stack
- Kotlin
- Jetpack Compose
- Navigation Compose (type-safe routes)
- ViewModel
- StateFlow
- Material Design 3

## Architecture Notes
- UI layer built entirely with Jetpack Compose
- Navigation handled through a centralized navigator
- State stored and shared via ViewModel scoped to a navigation graph
- Emphasis on UI composition and state flow, not data sources

## Disclaimer
This repository contains **learning-focused code only**.  
It is not intended to represent production-ready architecture or best practices beyond UI experimentation.

## Purpose
Practice and exploration of modern Android UI development with Jetpack Compose.
