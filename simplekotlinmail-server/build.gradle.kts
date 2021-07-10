plugins {
    `common-build-script`
    `java-version-script`
    `maven-publish-script`
}

dependencies {
    implementation(project(":${rootProject.name}-core"))

    api("com.github.davidmoten:subethasmtp:5.2.8")
}
