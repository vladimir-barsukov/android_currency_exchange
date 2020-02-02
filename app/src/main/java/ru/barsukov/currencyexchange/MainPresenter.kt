package ru.barsukov.currencyexchange

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.barsukov.currencyexchange.network.ApiService
import ru.barsukov.currencyexchange.network.ApiServiceFactory
import ru.barsukov.currencyexchange.network.CurrencyExchangeModel

class MainPresenter {

    private var view: IView? = null
    private lateinit var apiService: ApiService
    private lateinit var repository: MainRepository

    private var currencies: List<CurrencyExchangeModel>? = null

    fun onViewCreated(view: IView?) {
        this.view = view
        apiService = ApiServiceFactory().getInstance().getApiService()
        repository = MainRepository(apiService)
    }

    fun onLoadClick() {
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                view?.loading(true)
            }
            currencies = repository.getCurrencies()
            withContext(Dispatchers.Main) {
                view?.loading(false)
            }
        }
    }

}