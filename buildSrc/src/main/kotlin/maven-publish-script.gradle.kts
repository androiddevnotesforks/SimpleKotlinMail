val githubProject = "bluefireoly/SimpleKotlinMail"

description = "A simple, modern and coroutine based Kotlin Email API, supporting both clientside and serverside projects"

plugins {
    kotlin("jvm")
    `java-library`
    `maven-publish`
    signing
}

signing {
    sign(publishing.publications)
}

java {
    withSourcesJar()
    withJavadocJar()
}

publishing {
    repositories {
        maven("https://oss.sonatype.org/service/local/staging/deploy/maven2") {
            name = "ossrh"
            credentials(PasswordCredentials::class)
        }
    }

    publications {
        create<MavenPublication>(project.name) {
            from(components["java"])

            this.groupId = project.group.toString()
            this.artifactId = project.name
            this.version = project.version.toString()

            pom {
                name.set(project.name)
                description.set(project.description)

                developers {
                    developer {
                        name.set("bluefireoly")
                    }
                }

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }

                url.set("https://github.com/$githubProject")

                scm {
                    connection.set("scm:git:git://github.com/$githubProject.git")
                    url.set("https://github.com/$githubProject/tree/main")
                }
            }
        }
    }
}
