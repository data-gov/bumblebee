import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.gradle.build-scan") version "1.14"
    id("org.gradle.kotlin.kotlin-dsl") version "0.17.5"
    id("org.springframework.boot") version "2.0.3.RELEASE"
    id("io.gitlab.arturbosch.detekt") version "1.0.0.RC7-3"
    id("io.spring.dependency-management") version "1.0.5.RELEASE"
    id("com.avast.gradle.docker-compose") version "0.8.0"

    jacoco
    jdepend
    application

    kotlin("jvm") version "1.2.50"
    kotlin("plugin.spring") version "1.2.50"
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "br.com.bumblebee.BumblebeeKt"
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:Finchley.RELEASE")
        mavenBom("org.springframework.boot:spring-boot-dependencies:2.1.0.BUILD-SNAPSHOT")
    }
}

dependencies {
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))

    implementation("org.slf4j:slf4j-api:1.7.25")

    implementation("com.google.guava:guava:25.1-jre")
    implementation("com.squareup.okhttp3:okhttp:3.10.0")
    implementation("io.github.openfeign:feign-okhttp:9.7.0")

    implementation("io.github.microutils:kotlin-logging:1.5.4")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.data:spring-data-mongodb:2.1.0.M3")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.4.1")

    testImplementation(kotlin("test"))
    testImplementation("org.mockito:mockito-core:2.19.0")
    testImplementation("org.mockito:mockito-inline:2.19.0")
    testImplementation("io.rest-assured:rest-assured:3.1.0")
    testImplementation("com.tngtech.archunit:archunit:0.8.0")
    testImplementation("com.nhaarman:mockito-kotlin-kt1.1:1.6.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.1.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "junit")
    }

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.1.0")
}

repositories {
    jcenter()
    mavenCentral()
    maven(url = "https://plugins.gradle.org/m2/")
    maven(url = "https://repo.spring.io/libs-snapshot")
    maven(url = "https://repo.spring.io/libs-milestone")
}

apply(from = "${rootProject.rootDir}/gradle/git.gradle")
apply(from = "${rootProject.rootDir}/gradle/linter.gradle")
apply(from = "${rootProject.rootDir}/gradle/jdepend.gradle")
apply(from = "${rootProject.rootDir}/gradle/unit-test.gradle")
apply(from = "${rootProject.rootDir}/gradle/build-scan.gradle")
apply(from = "${rootProject.rootDir}/gradle/integration-test.gradle")
apply(from = "${rootProject.rootDir}/gradle/coverage.gradle")
apply(from = "${rootProject.rootDir}/gradle/docker-compose.gradle")
