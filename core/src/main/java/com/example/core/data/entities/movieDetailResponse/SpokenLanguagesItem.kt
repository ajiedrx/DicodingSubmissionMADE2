package com.example.dicodingsubmission2made.core.injection.data.entities.movieDetailResponse

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SpokenLanguagesItem(
	val name: String? = null,
	val iso6391: String? = null,
	val englishName: String? = null
) : Parcelable