plugins {
    kotlin("jvm") version "1.9.24"
    application
}

group = "iut.info2"
version = "2025.1.0"

repositories {
    mavenCentral()
    gradlePluginPortal() // nécessaire pour le plugin Kotlin
}

dependencies {
    // Tests unitaires
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.4")
    testImplementation("org.jetbrains.kotlin:kotlin-reflect:1.9.24")

    // Dépendance locale
}

tasks.test {
    useJUnitPlatform() // JUnit5
}

kotlin {
    jvmToolchain(17) // ou 21 si tu as le JDK 21
}

application {
    mainClass.set("MainKt") // Classe principale
}