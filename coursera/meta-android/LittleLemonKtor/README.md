# LittleLemonKtor

A learning project focused on working with network requests in Android using **Ktor Client**.

## Project Purpose
This project was created to practice:
- Making HTTP requests with Ktor
- Fetching data from a REST API
- Parsing JSON responses
- Mapping network DTOs to domain models
- Understanding basic data flow between network and presentation layers

## Tech Stack
- Kotlin
- Ktor Client (Android engine)
- kotlinx.serialization
- Coroutines
- Flow
- Android ViewModel

## Key Features
- GET requests to a remote API
- JSON response parsing
- DTO → domain model mapping
- Asynchronous operations with coroutines
- Reactive data handling using Flow

## Example Network Call
```kotlin
val response: MenuDto = httpClient.get(URL).body()
```