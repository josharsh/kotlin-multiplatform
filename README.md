# kotlin-multiplatform
Kotlin Multiplaform Scaffold for JS, Android and iOS

# How is the Project set up?
IntelliJ IDEA CE is used to set up this KMP project. The project was initialized as a Kotlin Multiplatform library.

### 1.1 Project Structure

- **src/commonMain/kotlin**: Contains the shared Kotlin code that is common to all platforms.
- **src/jvmMain/kotlin**: Contains the platform-specific Kotlin code for the JVM (Java Virtual Machine) platform, which includes Android.
- **src/jsMain/kotlin**: Contains the platform-specific Kotlin code for JavaScript.
- **src/iosMain/kotlin**: Contains the platform-specific Kotlin code for iOS.

### 1.2 Key Files & Folders

- **build.gradle.kts**: This file contains the build configuration for the project. It specifies the Kotlin Multiplatform plugin, target platforms, dependencies, and other build-related configurations.
- **settings.gradle.kts**: Specifies the project settings, including the project name and any included modules.
