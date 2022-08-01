import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    application
}

group = "me.daniel"
version = "1.0-SNAPSHOT"
val exposedVersion: String by project
val hikariVersion: String by project
val pgsqlVersion: String by project
val postGisVersion: String by project

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.zaxxer:HikariCP:$hikariVersion")
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-java-time:$exposedVersion")
    implementation("org.postgresql:postgresql:$pgsqlVersion")
    implementation("net.postgis:postgis-jdbc:$postGisVersion") {
        exclude(module = "postgresql")
    }
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "16"
}

application {
    mainClass.set("MainKt")
}