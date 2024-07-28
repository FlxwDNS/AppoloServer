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

java.sourceCompatibility = JavaVersion.VERSION_21
java.targetCompatibility = JavaVersion.VERSION_21

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}