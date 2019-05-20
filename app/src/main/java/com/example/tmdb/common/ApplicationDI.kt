package com.example.tmdb.common

import android.content.Context
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.example.tmdb.data.remote.MovieRemoteDataSource
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

class ApplicationModule(private val context: Context, private val fragmentActivity: FragmentActivity,
                        private val fm: FragmentManager, private val  containerID: Int) {
    @Provides
    @Singleton
    fun context() = context

    @Provides
    @Singleton
    fun retrofit() = Retrofit.Builder()
        .baseUrl("https://desafio-mobile.nyc3.digitaloceanspaces.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun cicerone(): Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    fun navigator(): Navigator = Navigator(fragmentActivity, fm, containerID)


    @Provides
    @Singleton
    fun movieRemoteDataSource(retrofit: Retrofit) = retrofit.create(MovieRemoteDataSource::class.java)
}