plugins {
    alias(libs.plugins.pages)
    alias(libs.plugins.git.publish)
}

pages {
    cayman {
        authorName = DEVELOPER_NAME
        authorUrl = DEVELOPER_URL
        projectName = RELEASE_ARTIFACT
        projectDescription = RELEASE_DESCRIPTION
        projectUrl = RELEASE_URL
    }
}

gitPublish {
    repoUri.set("git@github.com:$DEVELOPER_ID/$RELEASE_ARTIFACT.git")
    branch.set("gh-pages")
    contents.from(pages.outputDirectory)
}

tasks {
    register(LifecycleBasePlugin.CLEAN_TASK_NAME) {
        delete(buildDir)
    }
}
