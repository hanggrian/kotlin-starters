const val RELEASE_USER = "hendraanggrian"
const val RELEASE_GROUP = "io.github.$RELEASE_USER"
const val RELEASE_ARTIFACT = "plugin"
const val RELEASE_VERSION = "0.1"
const val RELEASE_DESCRIPTION = "Lorem ipsum."
const val RELEASE_URL = "https://github.com/$RELEASE_USER/$RELEASE_ARTIFACT"

fun getReleaseSourceUrl(project: String = RELEASE_ARTIFACT) =
    `java.net`.URL("$RELEASE_URL/tree/main/$project/src")