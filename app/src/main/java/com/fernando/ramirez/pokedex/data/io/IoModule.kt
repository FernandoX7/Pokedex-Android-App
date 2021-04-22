package com.fernando.ramirez.pokedex.data.io

import androidx.annotation.Nullable
import com.fernando.ramirez.pokedex.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object IoModule {

  @Provides
  @Singleton
  fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor()
      .apply {
        level = if (BuildConfig.DEBUG) {
          HttpLoggingInterceptor.Level.BODY
        } else {
          HttpLoggingInterceptor.Level.NONE
        }
      }
  }

  @Provides
  @Singleton
  fun providesOkHttpClient(
    httpLoggingInterceptor: HttpLoggingInterceptor,
  ): OkHttpClient {
    return OkHttpClient.Builder()
      .addInterceptor(httpLoggingInterceptor)
      .build()
  }

  @Provides
  @Singleton
  fun providesRestAdapter(@Nullable okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
      .baseUrl(BuildConfig.API)
      .addConverterFactory(GsonConverterFactory.create())
      .client(okHttpClient)
      .build()
  }
}
