plugins {
    `git-publish`
}

gitPublish {
    repoUri.set(RELEASE_URL)
    branch.set("gh-pages")
    contents.from("src")
}