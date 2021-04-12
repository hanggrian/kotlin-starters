plugins {
    `git-publish`
}

gitPublish {
    repoUri.set(RELEASE_GITHUB)
    branch.set("gh-pages")
    contents.from("src")
}