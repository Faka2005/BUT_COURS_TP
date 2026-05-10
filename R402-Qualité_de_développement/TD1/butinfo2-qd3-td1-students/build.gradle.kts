import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.1.10"
    application
}

group = "me.user"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("io.mockk:mockk:1.13.2")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "21"
    }
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("MainKt")
}
