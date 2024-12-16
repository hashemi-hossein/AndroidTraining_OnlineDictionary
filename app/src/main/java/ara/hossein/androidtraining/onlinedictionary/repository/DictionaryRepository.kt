package ara.hossein.androidtraining.onlinedictionary.repository

import ara.hossein.androidtraining.onlinedictionary.api.DictionaryApi
import ara.hossein.androidtraining.onlinedictionary.model.Meaning

class DictionaryRepository(private val api: DictionaryApi) {

    suspend fun getMeanings(word: String): List<Meaning> {
        return api.getMeanings(word).flatMap { it.meanings }
    }
}
