package com.hendraanggrian.generator

import com.google.gson.annotations.SerializedName
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.http.takeFrom

object GitHubApi {
    private const val endPoint = "https://api.github.com"
    private val client: HttpClient = HttpClient(OkHttp) {
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
    }

    suspend fun getLatestRelease(owner: String, repo: String): String = client
        .get<List<Release>> { apiUrl("repos/$owner/$repo/releases") }
        .mapNotNull { release -> release.bestGuess() }
        .first()

    private fun HttpRequestBuilder.apiUrl(path: String) {
        header(HttpHeaders.CacheControl, "no-cache")
        url {
            takeFrom(endPoint)
            encodedPath = path
        }
    }

    data class Release(
        @SerializedName("tag_name") val tagName: String,
        val name: String
    ) {

        fun bestGuess(): String? =
            tagName.clean() ?: name.clean()

        private fun String.clean(): String? {
            if (isEmpty() || none { it.isDigit() }) {
                return null
            }
            var result = this
            // remove non-digit prefix, like `v`
            if (!first().isDigit()) {
                result = result.substring(indexOf(result.first { it.isDigit() }), result.length)
            }
            return result
        }
    }
}