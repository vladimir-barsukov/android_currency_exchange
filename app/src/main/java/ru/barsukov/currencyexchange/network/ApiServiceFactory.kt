package ru.barsukov.currencyexchange.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

public class ApiServiceFactory {

    private var retrofit: Retrofit
    private lateinit var instance: ApiServiceFactory

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()


        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    fun getInstance(): ApiServiceFactory {
        if (instance == null) {
            instance = ApiServiceFactory()
        }

        return instance
    }

    fun getApiService(): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    companion object {
        const val BASE_URL = "https://revolut.duckdns.org"
    }

}