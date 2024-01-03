package com.quiraadev.hadithcompose.di

import android.content.Context
import com.quiraadev.hadithcompose.data.remote.api.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(): ApiInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.hadith.gading.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiInterface::class.java)
    }

}