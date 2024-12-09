package ara.hossein.androidtraining.onlinedictionary.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DictionaryApi {
    val retrofitService : DictionaryApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(DictionaryApiService::class.java)
    }
}

private const val BASE_URL = "https://api.dictionaryapi.dev"
