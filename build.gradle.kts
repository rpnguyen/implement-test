plugins {
    kotlin("jvm") version "2.2.0"
}

kotlin {
    jvmToolchain(21)
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    testLogging {
        events("passed", "skipped", "failed")
    }
}
