package truc

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import java.io.File


@OptIn(ExperimentalSerializationApi::class)
fun main(args: Array<String>) {

    val jsonparser = Json { ignoreUnknownKeys = true }

    val str = "{\"x\":42, \"s\":\"reponse\"}"

    var untruc: Truc = jsonparser.decodeFromString<Truc>(str)

    println(untruc)

    untruc = jsonparser
        .decodeFromStream<Truc>(
            File("data/truc.json").inputStream()
        )
    println(untruc)

    val trucs: List<Truc> = jsonparser
        .decodeFromStream<List<Truc>>(
            File("data/trucs.json").inputStream()
        )
    println(trucs)

}