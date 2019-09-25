package com.hendraanggrian.generator.api

import com.google.gson.annotations.SerializedName
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.get

object GitHubApi : Api("https://api.github.com", HttpClient(OkHttp) {
    install(JsonFeature) {
        serializer = GsonSerializer()
    }
}) {

    suspend fun getLatestRelease(owner: String, repo: String): String = client
        .get<List<Release>> { apiUrl("repos/$owner/$repo/releases") }
        .mapNotNull { it.version }
        .first()

    data class Release(@SerializedName("tag_name") val tagName: String, val name: String) {

        val version: String?
            get() = tagName.clean() ?: name.clean()
    }
}