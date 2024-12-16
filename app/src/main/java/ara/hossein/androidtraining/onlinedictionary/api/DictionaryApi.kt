package ara.hossein.androidtraining.onlinedictionary.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {
    @GET("api/v2/entries/en/{word}")
    suspend fun getMeanings(@Path("word") word: String): List<MeaningResponse>

    companion object {
        private const val BASE_URL = "https://api.dictionaryapi.dev/"

        fun create(): DictionaryApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DictionaryApi::class.java)
        }
    }
}

data class MeaningResponse(
    val word: String,
    val meanings: List<Meaning>
)

data class Meaning(
    val partOfSpeech: String,
    val definitions: List<Definition>
)

data class Definition(
    val definition: String,
    val example: String?
)
