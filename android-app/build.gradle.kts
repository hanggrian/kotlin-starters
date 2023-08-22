val RELEASE_GROUP: String by project
val RELEASE_VERSION: String by project

allprojects {
    group = RELEASE_GROUP
    version = RELEASE_VERSION
}
