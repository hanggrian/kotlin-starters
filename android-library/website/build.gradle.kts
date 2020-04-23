plugins {
    `git-publish`
}

gitPublish {
    repoUri.set(RELEASE_WEB)
    branch.set("gh-pages")
    contents.from(
        "src",
        "../$RELEASE_ARTIFACT/build/docs"
    )
}

tasks {
    "gitPublishCopy" {
        dependsOn(":$RELEASE_ARTIFACT:dokka")
    }
}