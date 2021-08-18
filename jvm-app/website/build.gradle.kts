plugins {
    `git-publish`
}

gitPublish {
    repoUri.set("git@github.com:hendraanggrian/kt-project-templates.git")
    branch.set("gh-pages")
    contents.from("src")
}

tasks {
    register("clean") {
        delete(buildDir)
    }
}