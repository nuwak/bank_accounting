import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val springVersion: String by project
val kotlinVersion: String by project

fun springBoot(name: String) = "org.springframework.boot:spring-boot-$name:$springVersion"

plugins {
    id("org.springframework.boot") version "2.6.7"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
}

group = "com.example"
java.sourceCompatibility = JavaVersion.VERSION_17
val testcontainersVersion = "1.17.3"


repositories {
    mavenCentral()
}

dependencies {
    implementation(springBoot("starter-data-jpa"))
    implementation(springBoot("starter-web"))
    implementation(springBoot("starter-actuator"))
    implementation(springBoot("starter-validation"))
    testImplementation(springBoot("starter-test"))

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.2")
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("org.liquibase:liquibase-core:4.9.1")
    runtimeOnly("org.postgresql:postgresql:42.3.3")

    implementation("io.github.microutils:kotlin-logging-jvm:2.1.21")
    implementation("ch.qos.logback:logback-classic:1.2.11")

    testImplementation("org.testcontainers:testcontainers:$testcontainersVersion")
    testImplementation("org.testcontainers:junit-jupiter:$testcontainersVersion")
    testImplementation("org.testcontainers:postgresql:$testcontainersVersion")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
