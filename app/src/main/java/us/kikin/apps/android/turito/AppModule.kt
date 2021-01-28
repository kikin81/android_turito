package us.kikin.apps.android.turito

import android.content.Context
import coil.ImageLoader
import coil.util.CoilUtils
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import us.kikin.apps.android.turito.network.AuthorizationInterceptor
import us.kikin.apps.android.turito.network.BusinessService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideBaseUrl() = "https://api.yelp.com/v3/"

    @Provides
    fun provideGson(): Gson =
        GsonBuilder()
            .setLenient()
            .create()

    @Provides
    @Singleton
    fun provideOkHttpClient(@ApplicationContext appContext: Context): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            // logcat debugger for debug builds
            val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            clientBuilder
                .addInterceptor(logger)
        }

        // header authentication
        clientBuilder.addInterceptor(AuthorizationInterceptor())

        return clientBuilder
            .cache(CoilUtils.createDefaultCache(appContext))
            .build()
    }

    @Provides
    @Singleton
    fun provideCoilImageLoader(
        @ApplicationContext appContext: Context,
        okHttpClient: OkHttpClient,
    ): ImageLoader {
        return ImageLoader.Builder(appContext)
            .crossfade(true)
            .okHttpClient(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        baseUrl: String,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): BusinessService =
        retrofit.create(BusinessService::class.java)
}
