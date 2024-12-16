package ara.hossein.androidtraining.onlinedictionary.model

data class Meaning(
    val partOfSpeech: String,
    val definitions: List<Definition>
)

data class Definition(
    val definition: String,
    val example: String?
)
