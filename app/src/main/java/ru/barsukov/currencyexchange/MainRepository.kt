package ru.barsukov.currencyexchange

import retrofit2.await
import ru.barsukov.currencyexchange.network.ApiService
import ru.barsukov.currencyexchange.network.CurrencyExchangeModel

class MainRepository(val apiService: ApiService) {

    suspend fun getCurrencies(): List<CurrencyExchangeModel> {
        return apiService.getCurrencies().await()
    }

}