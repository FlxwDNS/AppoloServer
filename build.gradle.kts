plugins {
    id("java")
    id("maven-publish")
}

group = "dev.appolo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}

dependencies {
    implementation("log4j:log4j:1.2.17")

    compileOnly("com.github.Minestom:minestom:461d0aa746")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}