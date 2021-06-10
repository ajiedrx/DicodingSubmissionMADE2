package com.example.dicodingsubmission2made.injection

import androidx.room.Room
import com.example.dicodingsubmission2made.core.injection.data.FilmRepository
import com.example.dicodingsubmission2made.core.injection.data.local.AppDatabase
import com.example.dicodingsubmission2made.core.injection.data.local.LocalDataSource
import com.example.dicodingsubmission2made.core.injection.data.remote.RemoteDataSource
import com.example.dicodingsubmission2made.core.injection.data.remote.api.ApiService
import com.example.dicodingsubmission2made.core.injection.domain.repository.IFilmRepository
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val databaseModule = module {
    factory { get<AppDatabase>().getDao() }

    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("dicoding".toCharArray())
        val factory = SupportFactory(passphrase)
         Room.databaseBuilder(androidContext(), AppDatabase::class.java, "appdb")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration().openHelperFactory(factory)
            .build()
    }
}

private val baseUrl = "https://api.themoviedb.org/"
val networkModule = module {
    single {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(
                RxJava2CallAdapterFactory.create())
            .build()

        retrofit.create(
            ApiService::class.java
        )
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    single<IFilmRepository> { FilmRepository(get(), get()) }
}

