package com.hendraanggrian.generator.api

import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.http.takeFrom

open class Api(private val endPoint: String, val client: HttpClient) {

    protected fun HttpRequestBuilder.apiUrl(path: String) {
        header(HttpHeaders.CacheControl, "no-cache")
        url {
            takeFrom(endPoint)
            encodedPath = path
        }
    }

    protected fun String.clean(): String? {
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