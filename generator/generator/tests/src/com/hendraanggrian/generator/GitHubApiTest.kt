package com.hendraanggrian.generator

import com.hendraanggrian.generator.api.GitHubApi
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class GitHubApiTest {

    @Test
    fun test() {
        assertEquals("0.1-rc1", runBlocking { GitHubApi.getLatestRelease("hendraanggrian", "kotlinpoet-ktx") })
    }
}