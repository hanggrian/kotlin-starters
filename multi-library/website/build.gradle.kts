plugins {
    pages
    `git-publish`
}

pages {
    minimal {
        authorName = DEVELOPER_NAME
        authorUrl = DEVELOPER_URL
        projectName = RELEASE_ARTIFACT
        projectDescription = RELEASE_DESCRIPTION
        projectUrl = RELEASE_URL
        markdownFile = rootDir.resolve("docs/README.md")
        headerButtons {
            button("View", "Documentation", "dokka")
        }
    }
}

gitPublish {
    repoUri.set("git@github.com:$DEVELOPER_ID/$RELEASE_ARTIFACT.git")
    branch.set("gh-pages")
    contents.from(pages.outputDirectory, "$rootDir/build/dokka")
}

tasks {
    register("clean") {
        delete(buildDir)
    }
    gitPublishCopy {
        dependsOn(":dokkaHtmlMultiModule")
    }
}