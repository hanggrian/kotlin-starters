plugins {
    `git-publish`
}

gitPublish {
    repoUri.set("git@github.com:hendraanggrian/kt-project-templates.git")
    branch.set("gh-pages")
    contents.from("src", "../$RELEASE_ARTIFACT/build/dokka")
}

tasks {
    register("clean") {
        delete(buildDir)
    }
    gitPublishCopy {
        dependsOn(":$RELEASE_ARTIFACT:dokkaHtml")
    }
}