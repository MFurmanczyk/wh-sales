import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.9.23"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "io.github.mfurmanczyk"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.apache.spark:spark-sql_2.13:3.3.1") // Apache Spark 3.3.1 for Scala 2.13
    implementation("org.jetbrains.kotlinx.spark:kotlin-spark-api_3.3.1_2.13:1.2.3") // Spark Kotlin API 1.2.3 for Apache Spark 3.3.1 (and Scala 2.13)
    implementation("com.fasterxml.jackson.core:jackson-core:2.14.2") // Required for proper work by other dependencies

    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

configurations.all {
    exclude(group = "org.slf4j", module = "slf4j-log4j12")
}

tasks{
    test {
        useJUnitPlatform()
    }

    register<ShadowJar>("buildExtraction") {
        group = "build spark"
        version = "1.0"
        archiveBaseName.set("extracts-mysql")
        mergeServiceFiles()
        exclude("META-INF/*.SF", "META-INF/*.DSA", "META-INF/*.RSA")
        manifest {
            attributes(
                "Main-Class" to ""
            )
        }
        from(sourceSets.main.get().output) {
            include("**/Sandbox1*.class")
        }
        configurations = listOf(project.configurations.runtimeClasspath.get())
        isZip64 = true
    }
}

kotlin {
    jvmToolchain(17)
}