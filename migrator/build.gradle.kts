import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    id("org.springframework.boot") version "2.7.8"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.8.0"
    kotlin("plugin.spring") version "1.8.0"
}

group = "org.appshapes"
version = "1.0"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    // project dependencies
    implementation(project(":common"))
    // third party dependencies
    runtimeOnly("com.mysql:mysql-connector-j:8.0.32")
    implementation("org.flywaydb:flyway-mysql")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-log4j2")
    implementation("org.apache.logging.log4j:log4j-layout-template-json")
    // testing dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

configurations {
    all { exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging") }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.freeCompilerArgs = listOf("-Xjsr305=strict")
    kotlinOptions.jvmTarget = "11"
    kotlinOptions.allWarningsAsErrors = true
}

tasks.withType<Test> {
    useJUnitPlatform()
}

application {
    mainClass.set("org.appshapes.flywaymigrator.migrator.ApplicationKt")
}