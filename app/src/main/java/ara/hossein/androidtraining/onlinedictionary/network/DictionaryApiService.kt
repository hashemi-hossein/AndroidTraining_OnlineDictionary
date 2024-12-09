package ara.hossein.androidtraining.onlinedictionary.network

import retrofit2.http.GET
import retrofit2.http.Path


interface DictionaryApiService {

    @GET("api/v2/entries/en/{word}")
    suspend fun getDefinition(@Path("word") word: String): List<Word>
}
