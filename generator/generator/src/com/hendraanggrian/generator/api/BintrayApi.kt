package com.hendraanggrian.generator.api

import io.ktor.client.request.get

object BintrayApi : Api("https://api.bintray.com") {

    suspend fun getLatestVersion(subject: String, repo: String, `package`: String): String = client
        .get<Result> { apiUrl("packages/$subject/$repo/$`package`/versions/_latest") }
        .name

    data class Result(val name: String)
}