package ru.barsukov.currencyexchange.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class CurrencyExchangeModel(
    val base: String?,

    val rates: List<Rate>?
): Parcelable

@Parcelize
class Rate(
    val currency: String?,

    val rate: Double?
): Parcelable