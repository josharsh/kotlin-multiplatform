plugins {
    kotlin("multiplatform") version "1.7.10"
    kotlin("native.cocoapods") version "1.7.10"
    `maven-publish`
}

group = "com.kmp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    cocoapods {
        // Name of the produced framework
        frameworkName = "kmp-scaffold"

        // Configure fields required by CocoaPods.
        summary = "Kotlin multiplatform library for all business logic for employee experience"
        homepage = "https://github.com/josharsh/kotlin-multiplatform"

        // CocoaPods version
        version = "1.0.0"

        // Define authors
        authors = "josharsh"

        // Define the license
        license = "MIT"

        // Define the iOS deployment target
        ios.deploymentTarget = "12.0"
    }
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(LEGACY) {
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val iOSTarget = when {
        hostOs == "Mac OS X" -> macosX64("iOS")
        hostOs == "Linux" -> linuxX64("iOS")
        isMingwX64 -> mingwX64("iOS")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
            }
        }
        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting
        val iOSMain by getting
        val iOSTest by getting
    }
}

publishing {
    publications {
        register("multiplatformLib", MavenPublication::class) {
            from(components["kotlin"])
            groupId = "com.kmp"
            artifactId = "employee.shared"
            version = "1.0.0"
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/josharsh/kotlin-multiplatform")

            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME_GITHUB")
                password = project.findProperty("gpr.token") as String? ?: System.getenv("TOKEN_GITHUB")
            }
        }
    }
}
