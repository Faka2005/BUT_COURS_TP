plugins {
    kotlin("jvm") version "2.0.21"
}

group = "iut.info2"
version = "2025.1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.4")
    implementation(kotlin("reflect"))
    implementation("net.sourceforge.plantuml:plantuml:1.2023.5")
    implementation(files("libs/univ.nantes.umlchecker-2.1.jar"))

}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}