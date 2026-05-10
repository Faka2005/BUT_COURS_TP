plugins {
    kotlin("jvm") version "2.1.21"
    kotlin("plugin.serialization") version "2.1.21"
}

group = "iut.info.but2"
version = "1.0-SNAPSHOT"

repositories {
    maven {
        url = uri("http://nexus.dep-info.iut-nantes.univ-nantes.prive/repository/public/")
        isAllowInsecureProtocol = true
    }
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.4")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.11.4")
    implementation("org.jetbrains.kotlin:kotlin-reflect:2.1.21")
    testImplementation("net.sourceforge.plantuml:plantuml:1.2025.2")
    testImplementation("org.slf4j:slf4j-api:2.0.9")
    testImplementation("ch.qos.logback:logback-classic:1.5.20") {
        exclude(group = "org.glassfish", module = "jakarta.el")
    }
    testImplementation(files("libs/univ.nantes.umlchecker-2.2.1.jar"))

    implementation("io.ktor:ktor-client-core:3.3.1")
    implementation("io.ktor:ktor-client-cio:3.3.1")
    implementation("io.ktor:ktor-client-content-negotiation:3.3.1")
    implementation("io.ktor:ktor-serialization-kotlinx-json:3.3.1")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}