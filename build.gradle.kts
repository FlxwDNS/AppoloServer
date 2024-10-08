plugins {
    id("java")
    id("maven-publish")

    id("com.gradleup.shadow") version "8.3.0"
}

group = "dev.appolo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://s01.oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
    compileOnly("net.minestom:minestom-snapshots:6fc64e3a5d")
    testImplementation("net.minestom:minestom-snapshots:6fc64e3a5d")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    sourceCompatibility = JavaVersion.VERSION_21.toString()
    targetCompatibility = JavaVersion.VERSION_21.toString()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "dev.appolo.server"
            artifactId = "appoloserver"
            version = "1.0-SNAPSHOT"

            from(components["java"])
        }
    }
}

/*
publishing {
    repositories {
        maven {
            name = "localhost"
            url = uri("http://127.0.0.1:8080/releases")
            credentials(PasswordCredentials::class)
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            groupId = "dev.appolo"
            artifactId = "appolo-server"
            version = "1.0.7"
            from(components["java"])
        }
    }
}
 */