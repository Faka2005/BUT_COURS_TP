package dev.mobile.tpsae

import android.app.Application
import dev.mobile.tpsae.data.remote.MovieAPI
import dev.mobile.tpsae.data.remote.SerieAPI
import dev.mobile.tpsae.data.repo.MovieRepo
import dev.mobile.tpsae.data.repo.SerieRepo
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.serialization.kotlinx.json.json

class MyApp : Application() {
    private val httpClient by lazy {
        HttpClient(Android){
            install(io.ktor.client.plugins.contentnegotiation.ContentNegotiation){
                json(kotlinx.serialization.json.Json{
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    private val movieApi by lazy {
        MovieAPI(httpClient)
    }

    private val serieApi by lazy {
        SerieAPI(httpClient)
    }

    val repo by lazy {
        MovieRepo(movieApi)
    }

    val repoS by lazy{
        SerieRepo(serieApi)
    }

}