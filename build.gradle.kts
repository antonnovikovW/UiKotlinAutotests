import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.lang.System.getenv

plugins {
    kotlin("jvm") version "1.5.10"
    id("io.qameta.allure") version "2.9.6"
}

val selenide_version: String by project
val allure_version: String by project
val kotlin_reflect_version: String by project
val testng_version: String by project
val assertj_version: String by project
val browserup_proxy_version: String by project
val netty_version: String by project
val slf4j_version: String by project

repositories {
    mavenCentral()
}

dependencies {
    //implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.codeborne:selenide:$selenide_version")
    implementation("com.codeborne:selenide-testng:$selenide_version")
    implementation("io.qameta.allure:allure-java-commons:$allure_version")
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlin_reflect_version")

    testRuntimeOnly("io.qameta.allure:allure-testng:$allure_version")
    testImplementation("io.qameta.allure:allure-attachments:$allure_version")
    testImplementation("io.qameta.allure:allure-generator:$allure_version")
    testImplementation("io.qameta.allure:allure-httpclient:$allure_version")
    testImplementation("io.qameta.allure:allure-selenide:$allure_version")
    implementation("org.slf4j:slf4j-api:$slf4j_version")
    implementation("org.slf4j:slf4j-nop:$slf4j_version")

    testImplementation("org.testng:testng:$testng_version")
    testImplementation("org.assertj:assertj-core:$assertj_version")
    testImplementation("com.browserup:browserup-proxy-core:$browserup_proxy_version")
    testImplementation("io.netty:netty-all:$netty_version")
}

//tasks.wrapper {
//    distributionType = Wrapper.DistributionType.ALL
//}

allure {
    adapter {
        allureJavaVersion.set(allure_version)
        autoconfigure.set(true)
        aspectjWeaver.set(true)
        frameworks {
            testng
        }
    }
}

tasks.test {
    useTestNG()
    setupSelenideProperties()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

fun Test.setupSelenideProperties() = apply {
    systemProperty("selenide.baseUrl", getenv("ENDPOINT_URL") ?: "https://webinar.ru/")
    systemProperty("selenide.timeout", getenv("TIMEOUT") ?: "20000")
    systemProperty("selenide.startMaximized", "true")
}