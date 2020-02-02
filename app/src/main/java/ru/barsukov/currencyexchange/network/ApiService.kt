package ru.barsukov.currencyexchange.network

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/latest")
    fun getCurrencies(): Call<List<CurrencyExchangeModel>>

}