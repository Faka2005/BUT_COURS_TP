package dev.mobile.tpsae.data.remote

import dev.mobile.tpsae.data.Resource
import dev.mobile.tpsae.BuildConfig
import dev.mobile.tpsae.data.dao.GenreDto
import dev.mobile.tpsae.data.dao.GenreResponseDto
import dev.mobile.tpsae.data.dao.MovieDto
import dev.mobile.tpsae.data.dao.MovieResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import java.util.Locale

class MovieAPI (private val client: HttpClient){

    private val baseUrl = "https://api.themoviedb.org/3"

    private val systemLanguage: String
        get() = Locale.getDefault().toLanguageTag()

    suspend fun getPopularMovies(page: Int = 1): Resource<List<MovieDto>>{
        return try{
            val res : MovieResponseDto = client.get("$baseUrl/movie/popular"){
                parameter("api_key", BuildConfig.TMDB_API_KEY)
                parameter("language", systemLanguage)
                parameter("page", page)
            }.body()
            Resource.Success(res.results)
        } catch (e: Exception){
            Resource.Error( e.message ?: "Couldn't get the popular movies")
        }
    }

    suspend fun searchMovies(query: String, page : Int = 1): Resource<List<MovieDto>>{
        return try{
            val res : MovieResponseDto = client.get("$baseUrl/search/movie"){
                parameter("api_key", BuildConfig.TMDB_API_KEY)
                parameter("query", query)
                parameter("language", systemLanguage)
                parameter("page", page)
            }.body()
            Resource.Success(res.results)
        } catch (e: Exception){
            Resource.Error( e.message ?: "Failed while searching movies")
        }
    }

    suspend fun getGenres(): Resource<List<GenreDto>>{
        return try{
            val res : GenreResponseDto = client.get("$baseUrl/genre/movie/list"){
                parameter("api_key", BuildConfig.TMDB_API_KEY)
                parameter("language", systemLanguage)
            }.body()
            Resource.Success(res.genres)
        } catch (e: Exception){
            Resource.Error( e.message ?: "Failed while searching for genres")
        }
    }
}