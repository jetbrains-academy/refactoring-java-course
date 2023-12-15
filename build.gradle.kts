import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun gradleProperties(key: String) = providers.gradleProperty(key)

group = gradleProperties("courseGroup").get()
version = gradleProperties("courseVersion").get()

plugins {
    id("org.jetbrains.intellij") version "1.14.1"
    java
    val kotlinVersion = "1.9.0"
    id("org.jetbrains.kotlin.jvm") version kotlinVersion apply false
    id("org.jlleitschuh.gradle.ktlint") version "10.0.0"
}

intellij {
    version.set("2022.1.1")
    plugins.set(listOf("java", "Kotlin"))
    type.set("IC")
}

allprojects {
    repositories {
        mavenCentral()
        mavenLocal()
        maven {
            // To be able to use the Kotlin test framework for the tests - https://github.com/jetbrains-academy/kotlin-test-framework
            url = uri("https://packages.jetbrains.team/maven/p/kotlin-test-framework/kotlin-test-framework")
        }
    }
}

tasks {
    wrapper {
        gradleVersion = gradleProperties("gradleVersion").get()
    }
}

// Configure dependencies for all gradle modules
configure(subprojects) {
    apply {
        plugin("java")
        plugin("kotlin")
    }

    // Include dependencies
    dependencies {
        val junitJupiterVersion = "5.9.0"
        implementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
        runtimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
        implementation("org.junit.jupiter:junit-jupiter-params:$junitJupiterVersion")
        runtimeOnly("org.junit.platform:junit-platform-console:1.9.0")

        testImplementation("org.ini4j:ini4j:0.5.4")
    }

    val jvmVersion = gradleProperties("jvmVersion").get()
    tasks {
        withType<KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = jvmVersion
            }
        }
        withType<JavaCompile> {
            sourceCompatibility = jvmVersion
            targetCompatibility = jvmVersion
        }

        // This part is necessary for the JetBrains Academy plugin
        withType<Test> {
            useJUnitPlatform()

            outputs.upToDateWhen { false }

            addTestListener(object : TestListener {
                override fun beforeSuite(suite: TestDescriptor) {}
                override fun beforeTest(testDescriptor: TestDescriptor) {}
                override fun afterTest(testDescriptor: TestDescriptor, result: TestResult) {
                    if (result.resultType == TestResult.ResultType.FAILURE) {
                        val message = result.exception?.message ?: "Wrong answer"
                        val lines = message.split("\n")
                        println("#educational_plugin FAILED + ${lines[0]}")
                        lines.subList(1, lines.size).forEach { line ->
                            println("#educational_plugin$line")
                        }
                        // we need this to separate output of different tests
                        println()
                    }
                }

                override fun afterSuite(suite: TestDescriptor, result: TestResult) {}
            })
        }
    }
}

// We have to store tests inside test folder directly
configure(subprojects.filter { it.name != "common" }) {
    sourceSets {
        getByName("main").java.srcDirs("src")
        getByName("test").java.srcDirs("test")
    }

    dependencies {
        implementation(project(":common"))
    }

    tasks.register<Exec>("run") {
        // Just do nothing to avoid the edu plugin errors
    }
}

configure(subprojects.filter { it.name.endsWith("Practice") }) {
    plugins.apply("org.jetbrains.intellij")

    intellij {
        version.set("2022.1.1")
        plugins.set(listOf("java", "Kotlin"))
        type.set("IC")
    }

    dependencies {
        val testSystemVersion = "2.1.0"
        testImplementation("org.jetbrains.academy.test.system:java-psi:$testSystemVersion")
        testImplementation("org.jetbrains.academy.test.system:common:$testSystemVersion")
    }
}

configure(subprojects.filter { it.name == "CodeStyleAndFormatting-CodeSchemasAndEditorConfig-ReformatTheCodeAccordingToStyleSettingsPractice" }) {
    apply {
        plugin("org.jlleitschuh.gradle.ktlint")
    }
    tasks.withType<KotlinCompile> {
        dependsOn("ktlintCheck")
    }
}
