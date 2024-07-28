plugins {
    id("java")
    id("maven-publish")
}

group = "dev.appolo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://s01.oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
    implementation("log4j:log4j:1.2.17")

    compileOnly("net.minestom:minestom-snapshots:6fc64e3a5d")
    testImplementation("net.minestom:minestom-snapshots:6fc64e3a5d")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    sourceCompatibility = JavaVersion.VERSION_21.toString()
    targetCompatibility = JavaVersion.VERSION_21.toString()
}

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
            version = "1.0.1"
            from(components["java"])
        }
    }
}