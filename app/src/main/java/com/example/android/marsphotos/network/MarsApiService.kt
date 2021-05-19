package com.example.android.marsphotos.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"
// ScalarsConverter to fetch JSON and return it as String.
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

/**
 * Defines how Retrofit talks to the web server using HTTP requests.
 */
interface MarsApiService {
    @GET ("photos") // Retrieve the endpoint "photos".
    fun getPhotos(): String
}

// Singleton object since app needs only one instance of Retrofit API service.
object MarsApi {
    // Lazy initialization, to make sure it is initialized at its first usage.
    val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }


}