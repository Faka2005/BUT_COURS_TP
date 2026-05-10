package dev.mobile.tpsae.data.remote

import dev.mobile.tpsae.data.Resource
import dev.mobile.tpsae.BuildConfig
import dev.mobile.tpsae.data.dao.GenreDto
import dev.mobile.tpsae.data.dao.GenreResponseDto
import dev.mobile.tpsae.data.dao.SerieDto
import dev.mobile.tpsae.data.dao.SerieResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import java.util.Locale

class SerieAPI (private val client: HttpClient){

    private val baseUrl = "https://api.themoviedb.org/3"

    private val systemLanguage: String
        get() = Locale.getDefault().toLanguageTag()

    suspend fun getPopularSeries(page: Int = 1): Resource<List<SerieDto>>{
        return try{
            val res : SerieResponseDto = client.get("$baseUrl/tv/popular"){
                parameter("api_key", BuildConfig.TMDB_API_KEY)
                parameter("language", systemLanguage)
                parameter("page", page)
            }.body()
            Resource.Success(res.results)
        } catch (e: Exception){
            Resource.Error( e.message ?: "Couldn't get the popular series")
        }
    }

    suspend fun searchSeries(query: String, page: Int = 1): Resource<List<SerieDto>>{
        return try{
            val res : SerieResponseDto = client.get("$baseUrl/search/tv"){
                parameter("api_key", BuildConfig.TMDB_API_KEY)
                parameter("query", query)
                parameter("language", systemLanguage)
                parameter("page", page)
            }.body()
            Resource.Success(res.results)
        } catch (e: Exception){
            Resource.Error( e.message ?: "Failed while searching series")
        }
    }

    suspend fun getGenresSeries(): Resource<List<GenreDto>>{
        return try{
            val res : GenreResponseDto = client.get("$baseUrl/genre/tv/list"){
                parameter("api_key", BuildConfig.TMDB_API_KEY)
                parameter("language", systemLanguage)
            }.body()
            Resource.Success(res.genres)
        } catch (e: Exception){
            Resource.Error( e.message ?: "Failed while searching for genres")
        }
    }
}