import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jlleitschuh.gradle.ktlint.KtlintExtension

plugins {
    val kotlinVersion = "1.8.21"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.allopen") version kotlinVersion
    kotlin("plugin.noarg") version kotlinVersion
    kotlin("kapt") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion

    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.3"
    id("org.jlleitschuh.gradle.ktlint") version "12.1.0"
    idea
}

java.sourceCompatibility = JavaVersion.VERSION_17
java.targetCompatibility = JavaVersion.VERSION_17

group = "kr.co.funch"
version = "1.0-SNAPSHOT"

object TestVersions {
    const val KOTEST_VERSION = "5.4.2"
    const val MOCKK_VERSION = "1.13.9"
}

tasks {
    test {
        useJUnitPlatform()
    }

    bootJar {
        enabled = false
    }
}

allprojects {
    repositories {
        mavenCentral()
        maven(url = "https://plugins.gradle.org/m2/")
        mavenLocal()
        gradlePluginPortal()
    }

    tasks {
        withType<Assemble> {
            dependsOn("ktlintFormat")
        }

        withType<KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = "17"
            }
        }

        withType<Test> {
            useJUnitPlatform()
            systemProperty("file.encoding", "UTF-8")
        }
    }
}

subprojects {
    apply {
        plugin("idea")
        plugin("kotlin")
        plugin("kotlin-kapt")
        plugin("org.jlleitschuh.gradle.ktlint")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("org.jetbrains.kotlin.plugin.allopen")
        plugin("org.jetbrains.kotlin.plugin.noarg")
    }

    group = "kr.co.funch.${path.split(":")[1]}"
    version = "0.0.1-SNAPSHOT"

    tasks {
        withType<Jar> {
            archiveFileName.set(
                project.path.split(":").drop(1).joinToString(separator = "-", postfix = "-") + project.version + ".jar",
            )
        }

        withType<Test> {
            useJUnitPlatform()
        }
    }

    dependencies {
        // Kotlin
        implementation(kotlin("reflect"))
        implementation(kotlin("stdlib-jdk8"))
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive:1.6.4")

        // kotest
        testImplementation("io.kotest:kotest-runner-junit5:${TestVersions.KOTEST_VERSION}")
        testImplementation("io.kotest:kotest-assertions-core:${TestVersions.KOTEST_VERSION}")
        testImplementation("io.mockk:mockk:${TestVersions.MOCKK_VERSION}")
    }

    configure<KtlintExtension> {
        filter {
            exclude { element -> element.file.path.contains("generated/") }
        }
    }
}
