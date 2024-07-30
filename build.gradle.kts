import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "2.0.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "io.github.mfurmanczyk"
version = "1.0"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(11)
}

dependencies {
    implementation ("org.jetbrains.kotlinx.spark:kotlin-spark-api_3.3.2_2.13:1.2.4")
    compileOnly ("org.apache.spark:spark-sql_2.13:3.3.2")

    implementation("com.fasterxml.jackson.core:jackson-core:2.14.2")

    implementation("com.mysql:mysql-connector-j:9.0.0") // MySQL Connector dependency
}

configurations.all {
    exclude(group = "org.slf4j", module = "slf4j-log4j12")
}

tasks{

    shadowJar {
        isZip64 = true
        archiveBaseName.set("wh-sales")
    }
}