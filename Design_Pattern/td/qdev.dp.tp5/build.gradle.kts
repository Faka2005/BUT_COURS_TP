plugins {
    kotlin("jvm") version "2.1.10"
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
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.4")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.11.4")
    testImplementation(kotlin("reflect"))
    testImplementation("net.sourceforge.plantuml:plantuml:1.2023.5")
    testImplementation(files("lib/univ.nantes.umlchecker-2.1.jar"))

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}