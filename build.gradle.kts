plugins {
    id("java")
}

group = "dev.appolo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("log4j:log4j:1.2.17")

    compileOnly("net.minestom:minestom-snapshots:12794d4263")
}