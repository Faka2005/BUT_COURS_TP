import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// https://betterprogramming.pub/how-to-improve-the-quality-of-tests-using-mutation-testing-2346019829f1

plugins {
    kotlin("jvm") version "1.9.22"
    id("info.solidsoft.pitest") version "1.19.0-rc.3"
    jacoco
    application
}


group = "palindrome"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.1")

    testImplementation("org.assertj:assertj-core:3.25.3")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "21"
    }
}

jacoco {
    toolVersion = "0.8.12"
    reportsDirectory.set(layout.buildDirectory.dir("customJacocoReportDir"))
}

//tasks.jacocoTestReport {
//    dependsOn(test)
//    reports {
//        html.required.set(true)
//        xml.required.set(true)
//    }
//}

pitest {
    junit5PluginVersion.set("1.2.1")
    targetClasses.set(listOf("palindrome.*"))
    targetTests.set(listOf("palindrome.*"))
    outputFormats.set(listOf("HTML"))
    timestampedReports.set(false)
    failWhenNoMutations.set(false)
}