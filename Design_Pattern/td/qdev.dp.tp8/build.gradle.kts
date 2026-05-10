plugins {
    kotlin("jvm") version "2.1.21"
    kotlin("plugin.serialization") version "2.1.21"
}

group = "iut.info.but2"
version = "1.0-SNAPSHOT"

repositories {
    /*maven {
        url = uri("http://nexus.dep-info.iut-nantes.univ-nantes.prive/repository/public/")
        isAllowInsecureProtocol = true
    }*/
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.4")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.11.4")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}