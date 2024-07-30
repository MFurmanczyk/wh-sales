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

dependencies {
    compileOnly("org.apache.spark:spark-sql_2.13:3.5.1") // Apache Spark 3.3.1 for Scala 2.13
    implementation("org.jetbrains.kotlinx.spark:kotlin-spark-api_3.3.1_2.13:1.2.4") // Spark Kotlin API 1.2.4 for Apache Spark 3.3.1 (and Scala 2.13)
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.0.0")

    implementation("com.mysql:mysql-connector-j:9.0.0") // MySQL Connector dependency

    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

configurations.all {
    exclude(group = "org.slf4j", module = "slf4j-log4j12")
}

tasks{
    test {
        useJUnitPlatform()
    }

    register<ShadowJar>("buildExtractionCustomer") {
        group = "build spark"
        version = "1.0"
        archiveBaseName.set("extracts-mysql-customer")
        mergeServiceFiles()
        exclude("META-INF/*.SF", "META-INF/*.DSA", "META-INF/*.RSA")
        manifest {
            attributes(
                "Main-Class" to "io.github.mfurmanczyk.jobs.CustomerExtractionKt"
            )
        }
        from(sourceSets.main.get().output) {
            include("**/CustomerExtractionKt.class")
            include("**/Customer*.class")
        }
        configurations = listOf(project.configurations.runtimeClasspath.get())
        isZip64 = true
    }
}

kotlin {
    jvmToolchain(17)
}