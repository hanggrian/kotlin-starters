package com.hendraanggrian.generator.api

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.get

object MavenCentralApi : Api("http://search.maven.org", HttpClient(OkHttp) {
    install(JsonFeature) {
        serializer = GsonSerializer()
    }
}) {

    suspend fun getLatestVersion(group: String, artifact: String): String = client
        .get<Result> { apiUrl("solrsearch/select?q=g:\"$group\"+AND+a:\"$artifact\"&core=gav") }
        .response
        .docs
        .mapNotNull { it.version }
        .first()

    data class Result(val response: Response)

    data class Response(val docs: List<Doc>)

    data class Doc(val v: String) {

        val version: String?
            get() = v
    }
}